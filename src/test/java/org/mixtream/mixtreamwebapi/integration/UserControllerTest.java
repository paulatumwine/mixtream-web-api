package org.mixtream.mixtreamwebapi.integration;


import lombok.extern.slf4j.Slf4j;
import org.mixtream.mixtreamwebapi.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

@Slf4j
@AutoConfigureWebTestClient(timeout = "60000")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest extends AbstractTestNGSpringContextTests {

    private static String BASE_URI = "/user";

    UserDTO request;
    String id;

    @Autowired
    WebTestClient client;

    @Test(dependsOnMethods={"testCreate"})
    public void testFindAll() {
        log.info("test find all");
        EntityExchangeResult<List<UserDTO>> result = client.get().uri(BASE_URI)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBodyList(UserDTO.class)
                .returnResult();
        assertNotNull(result.getResponseBody());
    }

    @Test(dependsOnMethods={"testCreate"})
    public void testFindByIdNotNull() {
        EntityExchangeResult<UserDTO> result = client.get()
                .uri(String.format("%s/%s", BASE_URI, id))
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(UserDTO.class)
                .returnResult();
        assertNotNull(result.getResponseBody());
    }

    @Test
    public void testCreate() {
        log.info("creating test data");
        this.request = UserDTO.builder()
                .email("default@mail.com")
                .build();
        EntityExchangeResult<UserDTO> result = client.post().uri(BASE_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(UserDTO.class)
                .returnResult();
        assertNotNull(result.getResponseBody());
        assertNotNull(result.getResponseBody().getId());
        id = result.getResponseBody().getId();
    }

    @Test(dependsOnMethods={"testCreate", "testFindByIdNotNull"})
    public void testUpdate() {
        log.info("updating test data");
        String updatedEmail = "updated@mail.com";
        request = UserDTO.builder()
                .email(updatedEmail)
                .build();
        EntityExchangeResult<UserDTO> result = client.put()
                .uri(String.format("%s/%s", BASE_URI, id))
                .bodyValue(request)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(UserDTO.class)
                .returnResult();
        assertNotNull(result.getResponseBody());
        assertEquals(result.getResponseBody().getEmail(), updatedEmail);
    }

    @Test(dependsOnMethods={"testUpdate"})
    public void testDelete() {
        client.delete()
                .uri(String.format("%s/%s", BASE_URI, id))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test(dependsOnMethods={"testDelete"})
    public void testFindByIdNull() {
        EntityExchangeResult<UserDTO> result = client.get()
                .uri(String.format("%s/%s", BASE_URI, id))
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(UserDTO.class)
                .returnResult();
        assertNull(result.getResponseBody());
    }
}
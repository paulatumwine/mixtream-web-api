package org.mixtream.mixtreamwebapi.integration;


import lombok.extern.slf4j.Slf4j;
import org.mixtream.mixtreamwebapi.dto.PlayDTO;
import org.mixtream.mixtreamwebapi.dto.TrackDTO;
import org.mixtream.mixtreamwebapi.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.testng.Assert.*;

@Slf4j
@AutoConfigureWebTestClient(timeout = "60000")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayControllerTest extends AbstractTestNGSpringContextTests {

    private static String BASE_URI = "/play";

    PlayDTO request;
    String id;

    @Autowired
    WebTestClient client;

    @Test(dependsOnMethods={"testCreate"})
    public void testFindAll() {
        log.info("test find all");
        EntityExchangeResult<List<PlayDTO>> result = client.get().uri(BASE_URI)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBodyList(PlayDTO.class)
                .returnResult();
        assertNotNull(result.getResponseBody());
    }

    @Test(dependsOnMethods={"testCreate"})
    public void testFindByIdNotNull() {
        EntityExchangeResult<PlayDTO> result = client.get()
                .uri(String.format("%s/%s", BASE_URI, id))
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(PlayDTO.class)
                .returnResult();
        assertNotNull(result.getResponseBody());
    }

    @Test
    public void testCreate() {
        log.info("creating test data");
        this.request = PlayDTO.builder()
                .playTime(LocalDateTime.now())
                .track(TrackDTO.builder().build())
                .user(UserDTO.builder().build())
                .build();
        EntityExchangeResult<PlayDTO> result = client.post().uri(BASE_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(PlayDTO.class)
                .returnResult();
        assertNotNull(result.getResponseBody());
        assertNotNull(result.getResponseBody().getId());
        id = result.getResponseBody().getId();
    }

    @Test(dependsOnMethods={"testCreate", "testFindByIdNotNull"})
    public void testUpdate() {
        log.info("updating test data");
        LocalDateTime time = LocalDateTime.now().minusMinutes(60);
        request = PlayDTO.builder()
                .playTime(time)
                .track(TrackDTO.builder().build())
                .user(UserDTO.builder().build())
                .build();
        EntityExchangeResult<PlayDTO> result = client.put()
                .uri(String.format("%s/%s", BASE_URI, id))
                .bodyValue(request)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(PlayDTO.class)
                .returnResult();
        assertNotNull(result.getResponseBody());
        assertEquals(result.getResponseBody().getPlayTime(), time);
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
        EntityExchangeResult<PlayDTO> result = client.get()
                .uri(String.format("%s/%s", BASE_URI, id))
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(PlayDTO.class)
                .returnResult();
        assertNull(result.getResponseBody());
    }
}
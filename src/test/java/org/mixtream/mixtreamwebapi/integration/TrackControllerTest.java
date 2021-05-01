package org.mixtream.mixtreamwebapi.integration;


import lombok.extern.slf4j.Slf4j;
import org.mixtream.mixtreamwebapi.dto.TrackDTO;
import org.mixtream.mixtreamwebapi.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

@Slf4j
@AutoConfigureWebTestClient(timeout = "60000")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TrackControllerTest extends AbstractTestNGSpringContextTests implements BaseContainer {

    private static String BASE_URI = "/track";

    TrackDTO request;
    String id;

    @Autowired
    WebTestClient client;

    @Test(dependsOnMethods={"testCreate"})
    public void testFindAll() {
        log.info("test find all");
        EntityExchangeResult<List<TrackDTO>> result = client.get().uri(BASE_URI)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBodyList(TrackDTO.class)
                .returnResult();
        assertNotNull(result.getResponseBody());
    }

    @Test(dependsOnMethods={"testCreate"})
    public void testFindByIdNotNull() {
        EntityExchangeResult<TrackDTO> result = client.get()
                .uri(String.format("%s/%s", BASE_URI, id))
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(TrackDTO.class)
                .returnResult();
        assertNotNull(result.getResponseBody());
    }

    @Test
    public void testCreate() {
        log.info("creating test data");
        this.request = TrackDTO.builder()
                .title("Default Track")
                .path("/path/to/track")
                .artist(Artist.builder().build())
                .build();
        EntityExchangeResult<TrackDTO> result = client.post().uri(BASE_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(TrackDTO.class)
                .returnResult();
        assertNotNull(result.getResponseBody());
        assertNotNull(result.getResponseBody().getId());
        id = result.getResponseBody().getId();
    }

    @Test(dependsOnMethods={"testCreate", "testFindByIdNotNull"})
    public void testUpdate() {
        log.info("updating test data");
        String updatedTitle = "Default Track Updated";
        request = TrackDTO.builder()
                .title(updatedTitle)
                .path("/path/to/track")
                .artist(Artist.builder().build())
                .build();
        EntityExchangeResult<TrackDTO> result = client.put()
                .uri(String.format("%s/%s", BASE_URI, id))
                .bodyValue(request)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(TrackDTO.class)
                .returnResult();
        assertNotNull(result.getResponseBody());
        assertEquals(result.getResponseBody().getTitle(), updatedTitle);
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
        EntityExchangeResult<TrackDTO> result = client.get()
                .uri(String.format("%s/%s", BASE_URI, id))
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(TrackDTO.class)
                .returnResult();
        assertNull(result.getResponseBody());
    }
}
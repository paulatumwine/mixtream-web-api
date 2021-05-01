package org.mixtream.mixtreamwebapi.integration;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;

public interface BaseContainer {
    @Container
    MongoDBContainer dbContainer = new MongoDBContainer("mongo:4.4.4")
                .withReuse(true);

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        dbContainer.start();
        registry.add("spring.data.mongodb.uri", dbContainer::getReplicaSetUrl);
    }
}

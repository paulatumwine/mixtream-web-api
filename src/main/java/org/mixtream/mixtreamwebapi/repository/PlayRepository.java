package org.mixtream.mixtreamwebapi.repository;

import org.mixtream.mixtreamwebapi.model.Play;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayRepository extends MongoRepository<Play, String> {
}

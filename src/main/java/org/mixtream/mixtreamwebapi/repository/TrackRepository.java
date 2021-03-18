package org.mixtream.mixtreamwebapi.repository;

import org.mixtream.mixtreamwebapi.model.Track;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackRepository extends MongoRepository<Track, String> {
}

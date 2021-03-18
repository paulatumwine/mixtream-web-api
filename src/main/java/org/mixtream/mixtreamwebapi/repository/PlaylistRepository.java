package org.mixtream.mixtreamwebapi.repository;

import org.mixtream.mixtreamwebapi.model.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaylistRepository extends MongoRepository<Playlist, String> {
}

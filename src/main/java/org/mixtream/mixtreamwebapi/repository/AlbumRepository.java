package org.mixtream.mixtreamwebapi.repository;

import org.mixtream.mixtreamwebapi.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, String> {
}

package org.mixtream.mixtreamwebapi.repository;

import org.mixtream.mixtreamwebapi.model.Album;
import org.mixtream.mixtreamwebapi.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistRepository extends MongoRepository<Artist, String> {
}

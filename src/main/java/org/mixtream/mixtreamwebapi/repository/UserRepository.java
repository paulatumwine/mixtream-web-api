package org.mixtream.mixtreamwebapi.repository;

import org.mixtream.mixtreamwebapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

package com.example.grupplabb.repositories;

import com.example.grupplabb.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

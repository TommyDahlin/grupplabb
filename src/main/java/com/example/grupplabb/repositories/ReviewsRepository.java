package com.example.grupplabb.repositories;

import com.example.grupplabb.models.Reviews;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends MongoRepository<Reviews, String> {

}

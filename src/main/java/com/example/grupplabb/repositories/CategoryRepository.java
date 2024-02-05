package com.example.grupplabb.repositories;

import com.example.grupplabb.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}

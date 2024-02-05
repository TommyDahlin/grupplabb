package com.example.grupplabb.repositories;

import com.example.grupplabb.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {



}

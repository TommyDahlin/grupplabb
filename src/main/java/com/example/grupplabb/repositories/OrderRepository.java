package com.example.grupplabb.repositories;

import com.example.grupplabb.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

}

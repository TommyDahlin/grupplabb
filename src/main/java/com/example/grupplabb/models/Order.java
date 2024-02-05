package com.example.grupplabb.models;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Order {
    @Id
    private String id;
    private User user;
    @NotBlank (message = "Field cannot be blank.")
    private String totalPrice;


    public Order() {
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getTotalPrice() {
        return totalPrice;
    }
}

package com.example.grupplabb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")

public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    public User() {
    }
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
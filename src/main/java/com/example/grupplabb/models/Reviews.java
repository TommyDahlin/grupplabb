package com.example.grupplabb.models;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/*

Postman - POST body instructions
POST to http://localhost:8080/api/reviews/add
body:
{
    "productId": "as7d68as76d8s76ad",
    "userId": "asdas8d7as97dsa6d976",
    "content": "This is a review."
}

*/


@Document(collection = "reviews")
public class Reviews {

    @Id
    private String id;

    @NotBlank(message = "Cannot be blank!")
    private String productId; // This line is used to fill in line below.

    @DBRef
    private Product product;

    @NotBlank(message = "Cannot be blank!")
    private String userId; // This line is used to fill in line below.

    @DBRef
    private User user;

    @NotBlank(message = "Cannot be blank!")
    private String content;

    public Reviews() {
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }
}

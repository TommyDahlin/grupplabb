package com.example.grupplabb.models;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
public class Reviews {

    @Id
    private String id;

    @NotBlank(message = "Cannot be blank!")
    private String productId;

    @DBRef
    private Product product;

    @NotBlank(message = "Cannot be blank!")
    private String userId;

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

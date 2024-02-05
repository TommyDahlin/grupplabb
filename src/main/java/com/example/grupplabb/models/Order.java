package com.example.grupplabb.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Order {
    @Id
    private String id;
    @NotBlank(message = "Field cannot be blank")

    private String userId;

    @DBRef
    private User user;

    @NotBlank(message = "Field cannot be blank")

    private String productId;

    @DBRef
    private Product product;

    @NotNull(message = "Field cannot be blank.")

    private int totalPrice;


    public Order() {
    }
    public String getId() {
        return id;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }


    public String getProductId() {
        return productId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getUserId() {
        return userId;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

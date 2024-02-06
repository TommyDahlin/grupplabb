package com.example.grupplabb.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "order")
public class Order {
    @Id
    private String id;

    @NotBlank(message = "Field cannot be blank")
    private String userId;

    @DBRef
    private User user;

    @NotBlank(message = "Field cannot be blank")
    private List<String> productId = new ArrayList<>();

    @DBRef
    private List<Product> product = new ArrayList<>();

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


    public List<String> getProductId() {
        return productId;
    }

    public List<Product> getProduct() {
        return product;
    }

    public String getUserId() {
        return userId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProductId(List<String> productId) {
        this.productId = productId;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

}

package com.example.grupplabb.models;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Order {
    @Id
    private String id;
    private String user;

    private String[] products;
    @NotNull(message = "Field cannot be blank.")
    private int totalPrice;


    public Order() {
    }
    public String getId() {
        return id;
    }
    public String getUser() {
        return user;
    }

    /*
    public String getTotalPrice() {
        return totalPrice;
    }
*/
    public void setUser(String user) {
        this.user = user;
    }

    public void setProducts(String products) {
        this.products = new String[]{products};
    }
/*
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
    */


    public String[] getProducts() {
        return products;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}

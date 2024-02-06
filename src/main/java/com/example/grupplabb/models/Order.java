package com.example.grupplabb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/*
Postman POST
body:
{
    "userId": "as8d97a9s8d",
    "productId": ["89as7ddas78", "89as7d89a7d"],
    "totalPrice": "400"
}
 */


@Document(collection = "orders")
public class Order {
    @Id
    private String id;

    //@NotBlank(message = "Field cannot be blank")
    private String userId;

    @DBRef
    private User user;

    //@NotBlank(message = "Field cannot be blank")
    private List<String> productId = new ArrayList<>();

    @DBRef
    private List<Product> product = new ArrayList<>();

    //@NotNull(message = "Field cannot be blank.")
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

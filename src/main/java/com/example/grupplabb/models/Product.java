package com.example.grupplabb.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
    @Id
    private String id;

    @NotBlank(message = "Field cannot be blank.")
    private String title;

    private String description;

    @NotNull(message = "Field cannot be blank.")
    private int price;


    public Product() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
/*
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    */

}

package com.example.grupplabb.models;

import org.springframework.data.annotation.Id;


public class Category {

    @Id
    public String id;
    public String categoryName;
    public Category() {
    }

    public String getId() {
        return id;
    }
    public String getCategoryName(){
        return categoryName;
    }
}
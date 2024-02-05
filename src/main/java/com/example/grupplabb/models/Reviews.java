package com.example.grupplabb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
public class Reviews {

    @Id
    private String id;

    @DBRef
    private String produktId;

    @DBRef
    private String userId;

    private String content;

    public Reviews() {
    }

    public String getId() {
        return id;
    }

    public String getProduktId() {
        return produktId;
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
}

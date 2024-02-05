package com.example.grupplabb.services;

import com.example.grupplabb.models.Product;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ProductService {
    // SKAPA NY POST
    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {

        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
}

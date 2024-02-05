package com.example.grupplabb.services;

import com.example.grupplabb.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired


    // skapa en produkt
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // hämta alla produkter
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}

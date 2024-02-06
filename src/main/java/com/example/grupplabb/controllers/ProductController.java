package com.example.grupplabb.controllers;

import com.example.grupplabb.exception.EntityNotFoundException;
import com.example.grupplabb.models.Product;
import com.example.grupplabb.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private Product product;

    @GetMapping("/webpage")
    public String Form(Model model){
        model.addAttribute("product", new Product());
        return "webpage";
    }

    @GetMapping("/personResult")
    public String personSubmit(@RequestParam String , @RequestParam String title, Model model){

        model.addAttribute("product", product);
        return "personresult";
    }







    // SKAPA NY - POST
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {

        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    // GET all products
    @GetMapping("/find")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // DELETE product
    @DeleteMapping("/delete{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product with id: " + id + " has been deleted!");
    }

    // PUT
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable String id,  @RequestBody Product productDetails) {
        try {
            Product updatedProduct = productService.updateProduct(id, productDetails);
            return ResponseEntity.ok(updatedProduct);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

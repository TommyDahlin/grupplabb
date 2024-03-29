package com.example.grupplabb.services;

import com.example.grupplabb.exception.EntityNotFoundException;
import com.example.grupplabb.models.Category;
import com.example.grupplabb.models.Product;
import com.example.grupplabb.repositories.CategoryRepository;
import com.example.grupplabb.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;


    // skapa en produkt
    public Product addProduct(Product product) {
        Category findCategory = categoryRepository.findById(product.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Couldn't find category."));
        product.setCategory(findCategory);
        return productRepository.save(product);
    }

    // hämta alla produkter
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    // uppdatera
    public Product updateProduct(String id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    if (updatedProduct.getTitle() != null) {
                        existingProduct.setTitle(updatedProduct.getTitle());
                    }
                    if (updatedProduct.getDescription() != null) {
                        existingProduct.setDescription(updatedProduct.getDescription());
                    }
                    if (updatedProduct.getPrice() != 0){
                        existingProduct.setPrice(updatedProduct.getPrice());
                    }

                    return productRepository.save(existingProduct);
                })
                .orElseThrow(() -> new EntityNotFoundException("product with id: " + id + " was not found!"));
    }
    // delete
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

}

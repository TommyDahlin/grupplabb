package com.example.grupplabb.services;

import com.example.grupplabb.models.Product;
import com.example.grupplabb.models.Reviews;
import com.example.grupplabb.models.User;
import com.example.grupplabb.repositories.ProductRepository;
import com.example.grupplabb.repositories.ReviewsRepository;
import com.example.grupplabb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService {

    @Autowired
    ReviewsRepository reviewsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    // Add a review
    public Reviews addReview(Reviews review) {
        // Find user with id from review body and save to temp user.
        User foundUser = userRepository.findById(review.getUserId())
                .orElseThrow(() -> new RuntimeException("User does not exist!"));
        // Find product with id from review body and save to temp product.
        Product foundProduct = productRepository.findById(review.getProductId())
                .orElseThrow(() -> new RuntimeException("Product does not exist!"));
        // Save temp user and product to review body.
        review.setUser(foundUser);
        review.setProduct(foundProduct);
        // Save and return review
        return reviewsRepository.save(review);
    }

    // List all reviews
    public List<Reviews> listAllReviews() {
        return reviewsRepository.findAll();
    }

    // Delete a review
    public String deleteReview(String id) {
        // Temp save all reviews
        List<Reviews> allReviews = reviewsRepository.findAll();
        // Check if id exist in temp reviews "allReviews"
        for (Reviews review : allReviews) {
            if (id.equals(review.getId())) {
                reviewsRepository.deleteById(id); // If true, delete
                return "Review deleted!";
            }
        }
        return "Review not found!"; // Else return error message.
    }
}

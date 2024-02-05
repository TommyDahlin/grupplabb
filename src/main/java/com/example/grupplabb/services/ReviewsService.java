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

    // Add review
    public Reviews addReview(Reviews review) {
        User foundUser = userRepository.findById(review.getUserId())
                .orElseThrow(() -> new RuntimeException("User does not exist!"));
        Product foundProduct = productRepository.findById(review.getProductId())
                .orElseThrow(() -> new RuntimeException("Product does not exist!"));
        review.setUser(foundUser);
        review.setProduct(foundProduct);
        return reviewsRepository.save(review);
    }

    // Get all reviews
    public List<Reviews> listAllReviews() {
        return reviewsRepository.findAll();
    }

    // Delete a review
    public String deleteReview(String id) {
        List<Reviews> allReviews = reviewsRepository.findAll();
        for (Reviews review : allReviews) {
            if (id.equals(review.getId())) {
                reviewsRepository.deleteById(id);
                return "Review deleted!";
            }
        }
        return "Review not found!";
    }
}

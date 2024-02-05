package com.example.grupplabb.services;

import com.example.grupplabb.models.Reviews;
import com.example.grupplabb.repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService {

    @Autowired
    ReviewsRepository reviewsRepository;

    // Add review
    public Reviews addReview(Reviews review) {
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

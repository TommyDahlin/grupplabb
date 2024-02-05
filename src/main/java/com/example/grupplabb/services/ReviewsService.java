package com.example.grupplabb.services;

import com.example.grupplabb.models.Reviews;
import com.example.grupplabb.repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewsService {

    @Autowired
    ReviewsRepository reviewsRepository;

    public Reviews addReview(Reviews review) {
        return reviewsRepository.save(review);
    }
}

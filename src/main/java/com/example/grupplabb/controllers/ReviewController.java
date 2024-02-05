package com.example.grupplabb.controllers;

import com.example.grupplabb.models.Reviews;
import com.example.grupplabb.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(/api/reviews)
public class ReviewController {

    @Autowired
    ReviewsService reviewsService;

    @PostMapping("/add")
    public Reviews addReview(@RequestBody Reviews review) {
        return reviewsService.addReview(review);
    }
}

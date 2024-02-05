package com.example.grupplabb.controllers;

import com.example.grupplabb.models.Reviews;
import com.example.grupplabb.services.ReviewsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    ReviewsService reviewsService;

    // POST review
    @PostMapping("/add")
    public Reviews addReview(@Valid @RequestBody Reviews review) {
        return reviewsService.addReview(review);
    }

    // GET reviews
    @GetMapping("find")
    public List<Reviews> listAllReviews() {
        return reviewsService.listAllReviews();
    }

    // DELETE a review
    @DeleteMapping("/delete/{id}")
    public String deleteReview(@PathVariable("id") String id) {
        return reviewsService.deleteReview(id);
    }
}

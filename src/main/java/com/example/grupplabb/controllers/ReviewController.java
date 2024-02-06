package com.example.grupplabb.controllers;

import com.example.grupplabb.models.Reviews;
import com.example.grupplabb.services.ReviewsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Quick CRUD API http://localhost:8080/api/reviews/*
    C - add
    R - find
    U - "Does not have"
    D - delete/:id
*/

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    ReviewsService reviewsService;

    // POST Add a review.
    @PostMapping("/add")
    public Reviews addReview(@Valid @RequestBody Reviews review) {
        return reviewsService.addReview(review);
    }

    // GET List all reviews.
    @GetMapping("/find")
    public List<Reviews> listAllReviews() {
        return reviewsService.listAllReviews();
    }

    // DELETE Remove a review from database.
    @DeleteMapping("/delete/{id}")
    public String deleteReview(@PathVariable("id") String id) {
        return reviewsService.deleteReview(id);
    }
}

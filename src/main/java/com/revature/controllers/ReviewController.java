package com.revature.controllers;


import com.revature.annotations.Secured;
import com.revature.dtos.UserDTO;
import com.revature.entities.Category;
import com.revature.entities.Review;
import com.revature.entities.Role;
import com.revature.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService rs;

    public ReviewController(ReviewService rs) {
        this.rs = rs;
    }

    @Secured(rolesAllowed = {"ADMIN", "MODERATOR"})
    @GetMapping
    public ResponseEntity<List<Review>> getReviews(){
        List<Review> reviews = rs.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @Secured(rolesAllowed = {"ADMIN", "MODERATOR"})
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable("id") int id){
        Review review = rs.getReviewById(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @Secured(rolesAllowed = {"ADMIN", "MODERATOR", "USER"})
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        review = rs.createReview(review);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @Secured(rolesAllowed = {"ADMIN", "MODERATOR"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Review> deleteReviewById(@PathVariable("id") int id){
        Review deleted = rs.deleteReviewById(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}

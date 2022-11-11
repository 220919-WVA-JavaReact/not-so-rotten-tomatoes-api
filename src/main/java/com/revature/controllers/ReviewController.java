package com.revature.controllers;


import com.revature.annotations.Secured;
import com.revature.dtos.ReviewDTO;
import com.revature.entities.Review;
import com.revature.services.ReviewService;
import com.revature.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService rs;
    private UserService us;

    public ReviewController(ReviewService rs, UserService us) {
        this.rs = rs;
        this.us = us;
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
    @GetMapping("/author/{id}")
    public ResponseEntity<List<Review>> getReviewsByAuthorId(@PathVariable("id") int id) {
        //create a new list to store the reviews
        List<Review> reviews = new ArrayList<>();
        //utilize ReviewService functionality to check by author id from database
        reviews = rs.getReviewsByAuthor(id);

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

//    @Secured(rolesAllowed = {"ADMIN", "MODERATOR", "USER"})
    @GetMapping("/recipe/{id}")
    public ResponseEntity<List<Review>> getReviewsByRecipeId(@PathVariable("id") int id) {
        //create a new list to store the reviews
        List<Review> reviews = new ArrayList<>();
        //utilize ReviewService functionality to check by recipe id from database
        reviews = rs.getReviewsByRecipe(id);

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @Secured(rolesAllowed = {"ADMIN", "MODERATOR", "USER"})
    @PostMapping("/recipe/{id}")
    public ResponseEntity<Review> createReview(@RequestBody ReviewDTO review){
        //utilize ReviewService functionality to add a review to the database
        Review newReview = rs.createReview(review);

        //return the added database information
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }

    @Secured(rolesAllowed = {"ADMIN", "MODERATOR"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Review> deleteReviewById(@PathVariable("id") int id){
        //utilize ReviewService functionality to delete a review from the database
        Review deleted = rs.deleteReviewById(id);

        //return the deleted database information
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}

package com.revature.controllers;


import com.revature.annotations.Secured;
import com.revature.dtos.UserDTO;
import com.revature.entities.Category;
import com.revature.entities.Review;
import com.revature.entities.Role;
import com.revature.services.ReviewService;
import com.revature.services.UserService;
import org.apache.catalina.User;
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
        List<Review> reviews = new ArrayList<>();
        reviews = rs.getReviewsByAuthor(id);

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @Secured(rolesAllowed = {"ADMIN", "MODERATOR", "USER"})
    @GetMapping("/recipe/{id}")
    public ResponseEntity<List<Review>> getReviewsByRecipeId(@PathVariable("id") int id) {
        List<Review> reviews = new ArrayList<>();
        reviews = rs.getReviewsByRecipe(id);

        return new ResponseEntity<>(reviews, HttpStatus.OK);
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

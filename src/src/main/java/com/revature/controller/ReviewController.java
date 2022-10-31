package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.ReviewModel;
import com.revature.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService rs;

    @Autowired
    public ReviewController(ReviewService rs) {
        this.rs = rs;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReviewModel>> getAllReviews() {
        List<ReviewModel> allReviews = rs.getAllReviews();
        if (allReviews == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(allReviews);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ReviewModel> createReview(@RequestBody ReviewModel r) {
        ReviewModel newReview = rs.createReview(r);
        if (newReview == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newReview);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ReviewModel> deleteReview(@RequestBody ReviewModel r) {
        ReviewModel delReview = rs.deleteReview(r);
        if (delReview == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(delReview);
        }
    }

}

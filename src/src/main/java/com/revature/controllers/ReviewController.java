package com.revature.controllers;


import com.revature.dtos.UserDTO;
import com.revature.entities.Category;
import com.revature.entities.Review;
import com.revature.entities.Role;
import com.revature.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    private ReviewService rs;

    public ReviewController(ReviewService rs) {
        this.rs = rs;
    }

//    @GetMapping("/reviews")
//    public ResponseEntity<List<Review>> getReviews(@RequestParam(name="category", required = false) Category category){
//        List<Review> reviews = null;
//        //If no request parms, return all users
//        if (category == null) {
//            reviews = rs.getAllReviews();
//            return new ResponseEntity<>(reviews, HttpStatus.OK);
//        } else {
////            reviews = rs.getReviewsByCategory(category);
////            return new ResponseEntity<>(reviews, HttpStatus.OK);
//            return new ResponseEntity<>(reviews, HttpStatus.OK);
//        }


//    }
}

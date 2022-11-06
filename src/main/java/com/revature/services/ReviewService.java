package com.revature.services;

import com.revature.entities.Review;
import com.revature.repositories.exceptions.ReviewNotFoundException;
import com.revature.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private ReviewRepository rr;

    @Autowired
    public ReviewService(ReviewRepository rr) {
        this.rr = rr;
    }

    public List<Review> getAllReviews(){
        List<Review> reviews = rr.findAll();

        return reviews;
    }


    public Review createReview(Review review) {
        //Check if user is logged in? grab user ID?
        rr.save(review);
        return review;
    }

    //Utilized by ID below
//    public Review deleteReview(Review review) {
//        //Check if user is logged in? grab user ID? Mock validate?
//        rr.delete(review);
//        return review;
//    }

    public Review deleteReviewById(int id){
        Review review = rr.findById(id).orElseThrow(() -> new ReviewNotFoundException());
        rr.delete(review);
        return review;
    }

    public Review getReviewById(int id) {
        Review review = rr.findById(id).orElseThrow(() -> new ReviewNotFoundException());
        return review;
    }
}

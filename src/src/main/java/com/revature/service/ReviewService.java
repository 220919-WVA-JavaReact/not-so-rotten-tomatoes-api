package com.revature.service;


import com.revature.model.ReviewModel;
import com.revature.repos.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewDao rd;
    @Autowired
    public ReviewService(ReviewDao rd) {
        this.rd = rd;
    }

    public ReviewModel createReview (ReviewModel r) {
        return rd.createReview(r);
    }

    public ReviewModel deleteReview (ReviewModel r) {
        return rd.deleteReview(r);
    }

    public List<ReviewModel> getAllReviews () {
        return rd.getAllReviews();
    }

}

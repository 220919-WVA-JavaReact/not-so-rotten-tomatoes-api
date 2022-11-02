package com.revature.services;

import com.revature.dtos.UserDTO;
import com.revature.entities.Category;
import com.revature.entities.Review;
import com.revature.entities.User;
import com.revature.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private ReviewRepository rr;

    @Autowired
    public ReviewService(ReviewRepository rr) {
        this.rr = rr;
    }

    public List<Review> getAllReviews(){
        List<Review> reviews = rr.findAll().stream().map(review -> new Review()).collect(Collectors.toList());

        return reviews;
    }


}

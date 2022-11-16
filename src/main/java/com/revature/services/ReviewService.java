package com.revature.services;


import com.revature.dtos.ReviewDTO;
import com.revature.entities.Recipe;
import com.revature.entities.Review;
import com.revature.entities.User;
import com.revature.exceptions.RecipeNotFoundException;
import com.revature.exceptions.ReviewNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.RecipeRepository;
import com.revature.repositories.ReviewRepository;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private ReviewRepository rr;
    private UserRepository ur;

    private RecipeRepository reciperepo;

    @Autowired
    public ReviewService(ReviewRepository rr, UserRepository ur, RecipeRepository reciperepo) {
        this.rr = rr;
        this.ur = ur;
        this.reciperepo = reciperepo;
    }


    public List<Review> getAllReviews(){
        //Use JPA to find all reviews that are in the database.
        List<Review> reviews = rr.findAll();

        //return all reviews.
        return reviews;
    }

    public List<Review> getReviewsByAuthor(int id) {
        //Use JPA to find a user by the unique id or else throw exception
        User u = ur.findById(id).orElseThrow(UserNotFoundException::new);
        //Utilize user id to find all the reviews and format into list.
        List<Review> reviews = rr.findByAuthor(u);

        //return list of reviews by author
        return reviews;
    }

    public List<Review> getReviewsByRecipe(int id) {
        //Use JPA to find a recipe by the unique id or else throw exception
        Recipe r = reciperepo.findById(id).orElseThrow(RecipeNotFoundException::new);
        //Utilize recipe id to find all the reviews and format into list.
        List<Review> reviews = rr.findByRecipeid(r);

        //return list of reviews by recipe id
        return reviews;
    }


    public Review createReview(ReviewDTO review) {
        //retrieve author by finding on the ID to keep password and email abstracted
        User u = ur.findById(review.getAuthorid()).orElseThrow(UserNotFoundException::new);
//        System.out.println("USER : " + u);
        //set author to what was found
        Review newReview = new Review();
        newReview.setAuthor(u);
        newReview.setReview_text(review.getReview_text());
        newReview.setRecipe_id(review.getRecipe_id());
//        System.out.println("ADDING TO REVIEW: " + newReview.getAuthor());
        //persist info to database by creating a new review
        if (!review.getReview_text().trim().equals("")) {
            rr.save(newReview);
        }

        //return the review information
        return newReview;
    }


    public Review deleteReviewById(int id){
        //Use JPA to find a review by the unique id or else throw exception
        Review review = rr.findById(id).orElseThrow(() -> new ReviewNotFoundException());

        //delete the review found in the database.
        rr.delete(review);

        //return deleted review information
        return review;
    }

    public Review getReviewById(int id) {
        //Use JPA to find a review by the unique id or else throw exception
        Review review = rr.findById(id).orElseThrow(() -> new ReviewNotFoundException());

        //return found review
        return review;
    }
}

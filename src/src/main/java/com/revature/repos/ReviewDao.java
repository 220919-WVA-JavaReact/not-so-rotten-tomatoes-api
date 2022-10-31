package com.revature.repos;

import com.revature.model.ReviewModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao {
    ReviewModel createReview(ReviewModel r);

    ReviewModel deleteReview(ReviewModel r);

    List<ReviewModel> getAllReviews();
}

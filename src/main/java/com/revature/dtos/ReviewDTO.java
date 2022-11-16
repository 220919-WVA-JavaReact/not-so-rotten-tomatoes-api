package com.revature.dtos;

import com.revature.entities.Recipe;
import com.revature.entities.Review;

import java.util.Objects;

public class ReviewDTO {

    private int authorid;
    private Recipe recipeid;
    private String review_text;

    public ReviewDTO() {
    }

    public ReviewDTO(Review review) {
        this.recipeid = review.getRecipe_id();
        this.review_text = getReview_text();
        this.authorid = review.getAuthor().getUser_id();
    }

    public Recipe getRecipe_id() {
        return recipeid;
    }

    public void setRecipe_id(Recipe recipe_id) {
        this.recipeid = recipe_id;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewDTO reviewDTO = (ReviewDTO) o;
        return authorid == reviewDTO.authorid && Objects.equals(recipeid, reviewDTO.recipeid) && Objects.equals(review_text, reviewDTO.review_text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorid, recipeid, review_text);
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "authorid=" + authorid +
                ", recipeid=" + recipeid +
                ", review_text='" + review_text + '\'' +
                '}';
    }
}

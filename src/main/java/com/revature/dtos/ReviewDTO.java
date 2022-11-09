package com.revature.dtos;

import com.revature.entities.Recipe;
import com.revature.entities.Review;

import java.util.Objects;

public class ReviewDTO {

    private Recipe recipeid;
    private String review_text;

    public ReviewDTO() {
    }

    public ReviewDTO(Review review) {
        this.recipeid = review.getRecipe_id();
        this.review_text = getReview_text();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewDTO reviewDTO = (ReviewDTO) o;
        return Objects.equals(recipeid, reviewDTO.recipeid) && Objects.equals(review_text, reviewDTO.review_text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeid, review_text);
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "recipe_id=" + recipeid +
                ", review_text='" + review_text + '\'' +
                '}';
    }
}

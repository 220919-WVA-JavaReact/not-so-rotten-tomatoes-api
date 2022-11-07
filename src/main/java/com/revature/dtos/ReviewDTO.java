package com.revature.dtos;

import com.revature.entities.Recipe;
import com.revature.entities.Review;

import java.util.Objects;

public class ReviewDTO {

    private Recipe recipe_id;
    private String review_text;

    public ReviewDTO() {
    }

    public ReviewDTO(Review review) {
        this.recipe_id = review.getRecipe_id();
        this.review_text = getReview_text();
    }

    public Recipe getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(Recipe recipe_id) {
        this.recipe_id = recipe_id;
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
        return Objects.equals(recipe_id, reviewDTO.recipe_id) && Objects.equals(review_text, reviewDTO.review_text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe_id, review_text);
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "recipe_id=" + recipe_id +
                ", review_text='" + review_text + '\'' +
                '}';
    }
}

package com.revature.model;

import java.util.Objects;

public class ReviewModel {

    int review_id;

    String author;

    String review_text;

    int recipe_id;

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewModel that = (ReviewModel) o;
        return review_id == that.review_id && recipe_id == that.recipe_id && author.equals(that.author) && review_text.equals(that.review_text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(review_id, author, review_text, recipe_id);
    }

    @Override
    public String toString() {
        return "ReviewModel{" +
                "review_id=" + review_id +
                ", author='" + author + '\'' +
                ", review_text='" + review_text + '\'' +
                ", recipe_id=" + recipe_id +
                '}';
    }
}

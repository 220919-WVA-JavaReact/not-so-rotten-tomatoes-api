package com.revature.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="reviews")
public class Review {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int review_id;
    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "user_id")
    private User author;
    @Column(nullable = false)
    private String review_text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
    private Recipe recipe_id;

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public Recipe getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(Recipe recipe_id) {
        this.recipe_id = recipe_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return review_id == review.review_id && Objects.equals(author, review.author) && Objects.equals(review_text, review.review_text) && Objects.equals(recipe_id, review.recipe_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(review_id, author, review_text, recipe_id);
    }

    @Override
    public String toString() {
        return "Review{" +
                "review_id=" + review_id +
                ", author=" + author +
                ", review_text='" + review_text + '\'' +
                ", recipe_id=" + recipe_id +
                '}';
    }
}

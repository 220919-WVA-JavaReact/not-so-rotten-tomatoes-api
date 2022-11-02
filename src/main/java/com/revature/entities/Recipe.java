package com.revature.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int recipe_id;
    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "user_id")
    private User author;
    @Column(nullable = false)
    private String recipe_name;
    @Column(nullable = false)
    private String instructions;
    @Enumerated(EnumType.STRING)
    private Category category;
    @OneToMany(mappedBy = "recipe_id")
    Set<Review> reviews;

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipe_id == recipe.recipe_id && Objects.equals(author, recipe.author) && Objects.equals(recipe_name, recipe.recipe_name) && Objects.equals(instructions, recipe.instructions) && category == recipe.category && Objects.equals(reviews, recipe.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe_id, author, recipe_name, instructions, category, reviews);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipe_id=" + recipe_id +
                ", author=" + author +
                ", recipe_name='" + recipe_name + '\'' +
                ", instructions='" + instructions + '\'' +
                ", category=" + category +
                ", reviews=" + reviews +
                '}';
    }
}

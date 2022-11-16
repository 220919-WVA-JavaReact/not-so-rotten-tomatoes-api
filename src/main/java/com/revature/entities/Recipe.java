package com.revature.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name="recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int recipe_id;
    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "user_id")
    private User author;
    @Column(nullable = false)
    private String recipe_name;
    @Column(nullable = false, columnDefinition="TEXT")
    private String instructions;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(columnDefinition = " varchar(255) default 'noimage.jpg'")
    private String filename;

    public Recipe(){}
    public Recipe(int recipe_id, User author, String recipe_name, String instructions, Category category) {
        this.recipe_id = recipe_id;
        this.author = author;
        this.recipe_name = recipe_name;
        this.instructions = instructions;
        this.category = category;
    }

    public Recipe(User author, String recipe_name, String instructions, Category category, String filename) {
        this.recipe_id = recipe_id;
        this.author = author;
        this.recipe_name = recipe_name;
        this.instructions = instructions;
        this.category = category;
        this.filename = filename;
    }

    public Recipe(Optional<Recipe> updated) {
       // this.instructions = String.valueOf(updated);
    }

    public Recipe(User u,  String title, String instructions, Category category) {
        this.author = u;
        this.instructions = instructions;
        this.recipe_name = title;
        this.category = category;
    }

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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipe_id == recipe.recipe_id && Objects.equals(author, recipe.author) && Objects.equals(recipe_name, recipe.recipe_name) && Objects.equals(instructions, recipe.instructions) && category == recipe.category && Objects.equals(filename, recipe.filename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe_id, author, recipe_name, instructions, category, filename);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipe_id=" + recipe_id +
                ", author=" + author +
                ", recipe_name='" + recipe_name + '\'' +
                ", instructions='" + instructions + '\'' +
                ", category=" + category +
                ", filename='" + filename + '\'' +
                '}';
    }
}

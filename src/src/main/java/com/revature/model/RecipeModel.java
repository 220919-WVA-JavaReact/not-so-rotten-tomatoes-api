package com.revature.model;

import java.util.Objects;

public class RecipeModel {

    private int recipe_id;

    private String author;

    private String recipe_name;

    private String instructions;

    private String category;

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeModel that = (RecipeModel) o;
        return recipe_id == that.recipe_id && author.equals(that.author) && recipe_name.equals(that.recipe_name) && instructions.equals(that.instructions) && category.equals(that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe_id, author, recipe_name, instructions, category);
    }

    @Override
    public String toString() {
        return "RecipeModel{" +
                "recipe_id=" + recipe_id +
                ", author='" + author + '\'' +
                ", recipe_name='" + recipe_name + '\'' +
                ", instructions='" + instructions + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

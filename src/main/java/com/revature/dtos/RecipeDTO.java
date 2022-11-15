package com.revature.dtos;

import com.revature.entities.Category;
import com.revature.entities.Recipe;


import java.util.Objects;

public class RecipeDTO {

    private int userid;
    private String instructions;
    private String title;
    private Category category;


    public RecipeDTO() {
    }

    public RecipeDTO(Recipe recipe) {
        this.userid = recipe.getAuthor().getUser_id();
        this.instructions = recipe.getInstructions();
        this.title = recipe.getRecipe_name();
        this.category = recipe.getCategory();
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeDTO recipe = (RecipeDTO) o;
        return userid == recipe.userid  && Objects.equals(title, recipe.title) && Objects.equals(instructions, recipe.instructions) && category == recipe.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash( userid, title, instructions, category);
    }

    @Override
    public String toString() {
        return "RecipeDTO{" +

                ", author=" + userid +
                ", recipe_name='" + title + '\'' +
                ", instructions='" + instructions + '\'' +
                ", category=" + category +
                '}';
    }
}


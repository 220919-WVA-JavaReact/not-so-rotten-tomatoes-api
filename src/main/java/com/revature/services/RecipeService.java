package com.revature.services;

import com.revature.entities.Recipe;
import com.revature.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    RecipeRepository rr;

    @Autowired
    public RecipeService(RecipeRepository rr) {
        this.rr = rr;
    }

    public List<Recipe> getAllRecipes() {
        return rr.findAll();
    }

    public Recipe createRecipe(Recipe recipe) {
        return rr.save(recipe);
    }

    public Optional<Recipe> getRecipeById(int id) {
        return rr.findById(id);
    }
}

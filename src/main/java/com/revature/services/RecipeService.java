package com.revature.services;

import com.revature.entities.Recipe;
import com.revature.exceptions.RecipeNotFoundException;
import com.revature.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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


    public Recipe updateRecipe(int id, String update) throws RecipeNotFoundException{
        Recipe recipe = null;
        try {
             recipe = rr.updateInstructions(id, update);
        } catch (RecipeNotFoundException r){
            r.getMessage();
        }

        // I need to return Optional<Recipe> if I want to use
        //the .orElseThrow method.Howver, I only want to return either a recipe or null , here.
    return recipe;

    }

}

package com.revature.services;

import com.revature.entities.Recipe;
import com.revature.repositories.exceptions.RecipeNotFoundException;
import com.revature.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Recipe updated = null;
        Recipe recipe = null;
        try {
             recipe = rr.getOne(id); //THIS SHOULD WORK!
             recipe.setInstructions(update);
             recipe = rr.save(recipe);
        } catch (RecipeNotFoundException r){
            r.getClass(); //currently ignored. Proceed?
        }
    return recipe;

    }

}

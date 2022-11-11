package com.revature.services;

import com.revature.entities.Category;
import com.revature.entities.Recipe;
import com.revature.entities.User;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.UserRepository;
import com.revature.repositories.RecipeRepository;
import com.revature.exceptions.RecipeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    RecipeRepository rr;
    UserRepository ur;

    @Autowired
    public RecipeService(RecipeRepository rr, UserRepository ur) {

        this.rr = rr;
        this.ur = ur;
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

    public Recipe updateRecipe(int id, Recipe update) throws RecipeNotFoundException{

        //extract new values out of update
        int authorint = update.getAuthor().getUser_id();
        String newTitle = update.getRecipe_name();
        String newInstructions = update.getInstructions();
        Category newCategory = update.getCategory();
        Recipe newRecipe = null;
        try {
             newRecipe = rr.getOne(id);
             //note: error handling is already taken care of, no need to check this value.
            // Will return a 400 bad request, saying
            //that no recipe exists with that id.

             //set new infos, save to db
            //newRecipe.setAuthor(authorint);
            newRecipe.setRecipe_name(newTitle);
            newRecipe.setInstructions(newInstructions);
            newRecipe.setCategory(newCategory);

            newRecipe = rr.save(newRecipe);
        } catch (RecipeNotFoundException r){
            r.getClass(); //currently ignored. Proceed?
        }
    return newRecipe;

    }

    public List<Recipe> getRecipeByAuthorId(int id){
        User u = ur.findById(id).orElseThrow(UserNotFoundException::new);
        return rr.findRecipesByAuthor(u);
    }

    public List<Recipe> findByRecipeContains(String searchTerm) {
        List<Recipe> res = rr.findByRecipeContains(searchTerm.toLowerCase());
        return res;
    }
}

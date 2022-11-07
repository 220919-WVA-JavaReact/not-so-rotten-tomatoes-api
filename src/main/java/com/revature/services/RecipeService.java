package com.revature.services;

import com.revature.entities.Category;
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


    public Recipe updateRecipe(int id, Recipe update) throws RecipeNotFoundException{

        //extract new values out of update
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
            newRecipe.setRecipe_name(newTitle);
            newRecipe.setInstructions(newInstructions);
            newRecipe.setCategory(newCategory);

            newRecipe = rr.save(newRecipe);
        } catch (RecipeNotFoundException r){
            r.getClass(); //currently ignored. Proceed?
        }
    return newRecipe;

    }
    public String deleteRecipe(int id) throws RecipeNotFoundException{
        //TODO: new recipe, newRecipe.setId(id), then delete(newRecipe)
        //TODO: DO I RETURN A STRING, OR AN OBJECT?
        Recipe deletedRecipe = null;
        String message = null;

        try {
            deletedRecipe = rr.getOne(id);
            rr.delete(deletedRecipe);
            message = "Successfully deleted!"; //TODO: TEST I WORK !
        } catch (RecipeNotFoundException r){
            //throw r; //TODO: TEST I WORK!
            throw new RecipeNotFoundException();
        }

        return message;
    }
}

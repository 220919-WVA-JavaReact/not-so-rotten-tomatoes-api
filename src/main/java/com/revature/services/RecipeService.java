package com.revature.services;

import com.revature.entities.Recipe;
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

    //@Query("UPDATE recipes SET instructions = ?2 WHERE recipe_id = ?2 RETURNING *")
    //Recipe update(int id, String update)
    //if this does not work, try with nativeQuery = true in the above query string.
    // syntax for nativeQuery:: @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)

    public Recipe updateRecipe(int id, String update){
//       // Recipe r = new Recipe();
//        if (rr.findById(id).isPresent()){
////            User user = ur.findById(id).orElseThrow(() -> new UserNotFoundException());
////            UserDTO userDTO = new UserDTO(user);
////
////            return userDTO;
//            Optional<Recipe> updated = rr.findById(id);
//
//            Recipe up = new Recipe(updated);
//          //  up.setInstructions(update);
//            return up; //currently, returning NOTHING !

//        } else {
//            return null;
//        }
    return null;

    }

}

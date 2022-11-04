package com.revature.controllers;


import com.revature.entities.Recipe;
import com.revature.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService rs;

    //TODO: WIRE UP PATCH REQUEST!
    @PatchMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable int id, @RequestBody String update){ // this SHOULD work, let's see.
        //TODO: CHANGE TO ACCEPT A JSON OBJECT! --> future
        // TODO: SEE IF WE NEED TO CHANGE THIS TO RETURN SOMETHING ELSE! ID not a recipe service!

        return new ResponseEntity<>(rs.updateRecipe(id, update), HttpStatus.OK ); //TODO: CHANGE ME!
        //deconstruct args, insert into below update statement

//        try {
//           // RecipeModel rm = RecipeService.update(id, rb.getInstructions()); //THIS IS FUTURE-PROOFING. We don't want to simply pass an int and a string in say, an array, then pull it out -- in future, we might want to update additional fields than just instructions ie
//            //TODO: IF ABOVE IS NULL, ERROR
//            //ELSE, PROCEED
//            return ResponseEntity.ok().build();
//        } catch (GenericJDBCException h){ //TODO: CREATE CUSTOM EXCEPTION, PASS HERE!
//           // return ResponseEntity.notFound().build();
//            h.printStackTrace();
//        }

//        return ResponseEntity.ok().build(); //just to see that we get *A* response!
    }

    public RecipeController(RecipeService rs){
        this.rs = rs;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return new ResponseEntity<>(rs.getAllRecipes(), HttpStatus.OK);
    }



}

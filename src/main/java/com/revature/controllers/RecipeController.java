package com.revature.controllers;


import com.revature.entities.Recipe;
import com.revature.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;


import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService rs;

    @PatchMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable int id, @RequestBody String update){ //TODO: UPDATE ME TO TAKE AN OBJECT!


      //TODO: I NEED TO SEND BACK THE WHOLE TICKET !
        ResponseEntity res = null;
        try {
            Recipe re = rs.updateRecipe(id, update); //if re is null, error, else, proceed.
            if (re == null){
                res = ResponseEntity.badRequest().build();
            } else {
                res = new ResponseEntity<>(re, HttpStatus.OK);
            }
        } catch (HttpClientErrorException h) {
            h.printStackTrace();
        }
       return res;
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

package com.revature.controllers;

import com.revature.entities.Recipe;
import com.revature.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    RecipeService rs;
    public RecipeController(RecipeService rs){
        this.rs = rs;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return new ResponseEntity<>(rs.getAllRecipes(), HttpStatus.OK);
    }

    @GetMapping(value="/{id}", produces="application/json")
    @ResponseBody
    public ResponseEntity<Optional<Recipe>> getRecipeById(@PathVariable("id") int id) {
        return new ResponseEntity<>(rs.getRecipeById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Recipe> createUser(@RequestBody Recipe recipe) {
        return new ResponseEntity<>(rs.createRecipe(recipe), HttpStatus.CREATED);
    }


}

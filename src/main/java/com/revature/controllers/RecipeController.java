package com.revature.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.RecipeDTO;
import com.revature.entities.Recipe;
import com.revature.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService rs;

    @PatchMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable int id, @RequestBody Recipe update){
        //@DOCS: YOU MUST PASS IN "ID" TO THE ANNOTATION ABOVE.
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

    @GetMapping(value="/{id}", produces="application/json")
    @ResponseBody
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") int id) {
        return new ResponseEntity<>(rs.getRecipeById(id), HttpStatus.OK);
    }

    @GetMapping(value="/users/{id}", produces="application/json")
    @ResponseBody
    public ResponseEntity<List<Recipe>> getRecipesByAuthorId(@PathVariable("id") int id) {
        return new ResponseEntity<>(rs.getRecipesByAuthorId(id), HttpStatus.OK);
    }

    @PostMapping(consumes = "multipart/form-data", produces = "application/json")
    public ResponseEntity<Recipe> createRecipe(@RequestParam String recipe, @RequestParam(required = false) MultipartFile file) throws JsonProcessingException {
        //intaking recipe as a string and then transferring back into an object below
        ObjectMapper mapper = new ObjectMapper();
        RecipeDTO recipeobj = mapper.readValue(recipe, RecipeDTO.class);
        return new ResponseEntity<>(rs.createRecipe(recipeobj, file), HttpStatus.CREATED);
    }

    @GetMapping(value="/search/{searchTerm}", produces="application/json")
    @ResponseBody
    public ResponseEntity<List<Recipe>> search(@PathVariable("searchTerm") String searchTerm) {
        return new ResponseEntity<>(rs.findByRecipeContains(searchTerm), HttpStatus.OK);
    }
}

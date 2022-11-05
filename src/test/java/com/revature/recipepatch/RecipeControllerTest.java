package com.revature.recipepatch;

//imports:: NEED recipe DAO, model, service (so we can mock these calls!)

import com.revature.controllers.RecipeController;
import com.revature.entities.Recipe;
import com.revature.entities.Role;
import com.revature.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class RecipeControllerTest { //TODO: I SHOULD ONLY TEST SERVICE LAYER METHODS!

    private RecipeController mockController;
//    @Test
//    void canGetAResponseOf200(){
//        //CURRENTLY, only a PATCH to /recipes/:id will work!
//        //Arrange,
//       // mockController = mockController.updateRecipe(1, "update");
//
//        //Act,
//        HttpStatus r = HttpStatus.valueOf(200);
//        Mockito.when(mockController.updateRecipe(1, "update")).thenReturn(new ResponseEntity<>(r));
//        //TODO: GET OUT OF THESE WEEDS!
//        //Assert
//    }
}

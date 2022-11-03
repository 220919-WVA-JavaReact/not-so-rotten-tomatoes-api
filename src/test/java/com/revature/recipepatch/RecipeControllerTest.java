package com.revature.recipepatch;

//imports:: NEED recipe DAO, model, service (so we can mock these calls!)

import com.revature.entities.Recipe;
import com.revature.entities.Role;
import com.revature.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class RecipeControllerTest {
    @Test
    void canGetAResponseOf200(){
        //CURRENTLY, only a PATCH to /recipes/:id will work!
        //Arrange,
        Recipe updated = new Recipe();
        User loser = new User();

        loser.setUser_id(1);
        loser.setUsername("loser1");
        loser.setEmail("e@mail.net");
        loser.setPassword("password");
        loser.setRole(Role.USER);

        updated.setRecipe_id(1);
        updated.setAuthor(loser);

        //Act,

        //Assert
    }
}

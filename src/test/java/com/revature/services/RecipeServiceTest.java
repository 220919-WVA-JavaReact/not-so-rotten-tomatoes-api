package com.revature.services;

import com.revature.NsrtApplication;
import com.revature.entities.Category;
import com.revature.entities.Recipe;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.repositories.exceptions.RecipeNotFoundException;
import com.revature.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes= NsrtApplication.class)
public class RecipeServiceTest {

    @MockBean
    private RecipeRepository mockRepository;

    @Autowired
    private RecipeService sut; //"service under test", as is convention for naming these.

    //delete by id returns a string message
    @Test
    public void deleteByIdReturnsMessage(){
        User testMan = new User();

        testMan.setUser_id(1);
        testMan.setEmail("e@mail.com");
        testMan.setPassword("password used?");
        testMan.setUsername("tmtotherescue");
        testMan.setRole(Role.USER);

        Recipe testRecipe = new Recipe();
        testRecipe.setRecipe_id(1);
        testRecipe.setRecipe_name("Hashbrowns");
        testRecipe.setInstructions("Dont burn them you'll be fine");
        testRecipe.setAuthor(testMan);
        testRecipe.setCategory(Category.Dessert);

        Mockito.when(mockRepository.findById(1)).thenReturn(Optional.of(testRecipe));

        String expected = "Successfully deleted!";

        String actual = sut.deleteRecipe(1);

        assertEquals(expected, actual);
    }

    //delete by id throws recipe not found xception
    @Test
    public void deleteThrowsRecNotFoundException(){
        Mockito.when(mockRepository.findById(1000)).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> sut.deleteRecipe(1000));

    }

    //cannot delete if wrong user --> throws wrong user xception, ie

    //update recipe throws RecipeNotFound xception

    //update recipe returns new recipe

    //
}

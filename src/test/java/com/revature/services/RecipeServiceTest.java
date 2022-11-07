package com.revature.services;

import com.revature.NsrtApplication;
import com.revature.entities.Recipe;
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

    //delete by id throws recipe not found xception

    //cannot delete if wrong user --> throws wrong user xception, ie
}

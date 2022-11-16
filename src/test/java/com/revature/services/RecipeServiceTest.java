package com.revature.services;

import com.revature.NsrtApplication;
import com.revature.entities.Category;
import com.revature.entities.Recipe;
import com.revature.entities.User;
import com.revature.exceptions.RecipeNotFoundException;
import com.revature.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes= NsrtApplication.class)
public class RecipeServiceTest {

    @MockBean
    private RecipeRepository rr;

    @Autowired
    private RecipeService rs;

    @Test
    public void getRecipeByIdExists(){
//        User cory = new User("12cwarden", "12cwarden@gmail.com", "test");

        User patrick = new User("patrick", "patrick@test.com", "test");
//        recipes(author, recipe_name, instructions, category) values ('1', 'Cake', 'bake', 'Dessert');
        Recipe recipe = new Recipe(1, patrick, "Cake", "bake", Category.Dessert);

        Mockito.when(rr.findById(1)).thenReturn(Optional.of(recipe));

        Recipe expected = new Recipe(1, patrick, "Cake", "bake", Category.Dessert);
        Recipe actual = rs.getRecipeById(1);

        assertEquals(expected, actual);
    }

    @Test
    public void getRecipeByIdNotFound() {
        Mockito.when(rr.findById(88)).thenReturn(Optional.empty());
        assertThrows(RecipeNotFoundException.class, () -> rs.getRecipeById(88));
    }

    @Test
    public void getAllRecipesWorks() {
        User patrick = new User("patrick", "patrick@test.com", "test");
        Recipe recipe1 = new Recipe(1, patrick, "Cake", "bake", Category.Dessert);
        Recipe recipe2 = new Recipe(2, patrick, "Pizza", "bake", Category.Entree);
        List<Recipe> recipes = new ArrayList<Recipe>();
        recipes.add(recipe1);
        recipes.add(recipe2);

        Mockito.when(rr.findAll()).thenReturn(recipes);
        int expected = recipes.size();
        int actual = rs.getAllRecipes().size();
        assertEquals(expected, actual);
    }

    @Test
    public void CreateRecipeWorks() {
        User patrick = new User("patrick", "patrick@test.com", "test");
        Recipe recipe = new Recipe(1, patrick, "Cake", "bake", Category.Dessert);

        Mockito.when(rr.save(recipe)).thenReturn(recipe);
        Recipe actual = rr.save(recipe);
        assertEquals(recipe, actual);
    }

    @Test
    public void findByRecipeWorks() {
        String searchTerm = "food";
        Recipe burrito = new Recipe();
        burrito.setRecipe_id(1);
        burrito.setRecipe_name("food");
        List<Recipe> recipes= new ArrayList<>();
        recipes.add(burrito);
        Mockito.when(rr.findByRecipeContains(searchTerm)).thenReturn(recipes);

        List<Recipe> expected = new ArrayList<>();
        expected.add(burrito);

        List<Recipe> actual = rs.findByRecipeContains(searchTerm);

        assertEquals(expected, actual);
    }

}

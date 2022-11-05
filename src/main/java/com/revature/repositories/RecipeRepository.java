package com.revature.repositories;

import com.revature.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
//    @Query(value = "SELECT (*) FROM recipes WHERE recipe_id = ?1")
    Recipe getOne(int id);

   // @Query("UPDATE Recipe SET instructions = ?2 WHERE recipe_id = ?1")
    Recipe save(String update);
}

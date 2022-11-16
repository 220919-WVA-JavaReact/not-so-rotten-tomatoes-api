package com.revature.repositories;

import com.revature.entities.Recipe;
import com.revature.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    Recipe getOne(int id);

    //@DOCS: getOne only fetches a REFERENCE (proxy) of the object, then the below save executes an UPDATE statement as you expect.
    //@DOCS: see https://stackoverflow.com/questions/39741102/how-to-beautifully-update-a-jpa-entity-in-spring-data --> first answer for more infos
    Recipe save(Recipe update);

    List<Recipe> findRecipesByAuthor(User u);

    @Query(value="SELECT * FROM Recipes r WHERE LOWER(r.recipe_name) LIKE %:searchTerm% OR LOWER(r.instructions) LIKE %:searchTerm% OR LOWER(r.category) LIKE %:searchTerm%", nativeQuery = true)

    List<Recipe> findByRecipeContains(@Param("searchTerm") String searchTerm);
}

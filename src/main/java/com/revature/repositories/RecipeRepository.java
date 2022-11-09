package com.revature.repositories;

import com.revature.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    Recipe getOne(int id);

    //@DOCS: getOne only fetches a REFERENCE (proxy) of the object, then the below save executes an UPDATE statement as you expect.
    //@DOCS: see https://stackoverflow.com/questions/39741102/how-to-beautifully-update-a-jpa-entity-in-spring-data --> first answer for more infos
    Recipe save(Recipe update);

//    void delete(Recipe deleted);
// @DOCS: I AM DEPRECATED, BECAUSE DELETE NOW USES FINDBYID, WHICH EXPECTS AN OPTIONAL
    //RATHER THAN A RECIPE LITERAL.

//    @Modifying(clearAutomatically = true, flushAutomatically = true)
//    @Query(value = "delete from recipes where recipes.recipe_id = 2 cascade", nativeQuery = true)
    //native deprecated, i dont want to write own SQL.
    void deleteById(int id); //@Param("id")
    //@DOCS: clear auto, because we need persistence context to update, and flush auto, in case we have uncommited changes.
}

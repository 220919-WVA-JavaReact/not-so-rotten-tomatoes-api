package com.revature.repositories;

import com.revature.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    Recipe getOne(int id);

    //@DOCS: getOne only fetches a REFERENCE (proxy) of the object, then the below save executes an UPDATE statement as you expect.
    //@DOCS: see https://stackoverflow.com/questions/39741102/how-to-beautifully-update-a-jpa-entity-in-spring-data --> first answer for more infos
    Recipe save(Recipe update);
}

package controllers;

import com.revature.services.RecipeService;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    @Autowired
    private RecipeService rs;

    //TODO: WIRE UP PATCH REQUEST!
    @PatchMapping("/{id}")
    public ResponseEntity<RecipeService> updateRecipe(@PathVariable int id){ // @RequestBody RecipeModel rb //TODO: SEE IF WE NEED TO CHANGE THIS TO RETURN SOMETHING ELSE! ID not a recipe service!
        //MY RETURN TYPE SHOULD BE A RECIPE MODEL,
        // _NOT_ A RECIPE SERVICE!

        //deconstruct args, insert into below update statement

//        try {
//           // RecipeModel rm = RecipeService.update(id, rb.getInstructions()); //THIS IS FUTURE-PROOFING. We don't want to simply pass an int and a string in say, an array, then pull it out -- in future, we might want to update additional fields than just instructions ie
//            //TODO: IF ABOVE IS NULL, ERROR
//            //ELSE, PROCEED
//            return ResponseEntity.ok().build();
//        } catch (GenericJDBCException h){ //TODO: CREATE CUSTOM EXCEPTION, PASS HERE!
//           // return ResponseEntity.notFound().build();
//            h.printStackTrace();
//        }

        return ResponseEntity.ok().build(); //just to see that we get *A* response!
    }

}

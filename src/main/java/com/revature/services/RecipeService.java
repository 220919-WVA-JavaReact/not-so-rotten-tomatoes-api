package com.revature.services;

import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    //I NOW directly call recipe repository r.updateById(id, update) or some such. I  may need to be manually done, we will see.
    //TODO: RESEARCH HOW PATCH REQUESTS WORK IN JPA repository!
    //@Query("UPDATE recipes SET instructions = ?2 WHERE recipe_id = ?2 RETURNING *")
    //Recipe update(int id, String update)
    //if this does not work, try with nativeQuery = true in the above query string.
}

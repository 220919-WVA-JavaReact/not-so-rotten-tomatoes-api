package com.revature.exceptions;

<<<<<<< HEAD:src/main/java/com/revature/exceptions/RecipeNotFoundException.java
package com.revature.exceptions;
=======
package com.revature.repositories.exceptions;
>>>>>>> 5edc3cb536e01220689aea2be3b04ff956b54b94:src/main/java/com/revature/repositories/exceptions/RecipeNotFoundException.java

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

<<<<<<< HEAD:src/main/java/com/revature/exceptions/RecipeNotFoundException.java
@ResponseStatus(value= HttpStatus.FOUND, reason = "Recipe not found.")
public class RecipeNotFoundException extends RuntimeException{
=======
@ResponseStatus(value= HttpStatus.FOUND, reason = "recipe not found.")
public class RecipeNotFoundException extends RuntimeException {
>>>>>>> 5edc3cb536e01220689aea2be3b04ff956b54b94:src/main/java/com/revature/repositories/exceptions/RecipeNotFoundException.java
}

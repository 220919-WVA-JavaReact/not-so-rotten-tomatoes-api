package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Recipe not found.")
public class RecipeNotFoundException extends RuntimeException{
}

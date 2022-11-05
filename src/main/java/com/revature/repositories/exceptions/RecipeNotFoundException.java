package com.revature.repositories.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.FOUND, reason = "recipe not found.")
public class RecipeNotFoundException extends RuntimeException {
}

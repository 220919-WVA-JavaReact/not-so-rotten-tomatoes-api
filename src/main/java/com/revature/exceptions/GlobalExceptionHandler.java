package com.revature.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    // from slf4j
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value= HttpStatus.FOUND, reason = "User not found.")
    @ExceptionHandler(UserNotFoundException.class)
    public void handleUserNotFoundException(Exception e) {
        log.error("Exception caught: ", e);
    }

    @ResponseStatus(value= HttpStatus.FOUND, reason = "Recipe not found.")
    @ExceptionHandler(RecipeNotFoundException.class)
    public void handleRecipeNotFoundException(Exception e) { log.error("Exception caught: ", e); }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "Login unsuccessful.")
    @ExceptionHandler(LoginException.class)
    public void handleLoginException(Exception e) {
        log.error("Exception caught: ", e);
    }

    @ResponseStatus(value= HttpStatus.FOUND, reason = "Review not found.")
    @ExceptionHandler(ReviewNotFoundException.class)
    public void handleReviewNotFoundException(Exception e) {
        log.error("Exception caught: ", e);
    }

    @ResponseStatus(value= HttpStatus.UNAUTHORIZED, reason = "Unable to process request; please sign in.")
    @ExceptionHandler(AuthenticationException.class)
    public void handleAuthenticationException(Exception e) {
        log.error("Exception caught: ", e);
    }

    @ResponseStatus(value= HttpStatus.UNAUTHORIZED, reason = "You do not have permission to perform this action.")
    @ExceptionHandler(AuthorizationException.class)
    public void handleAuthorizationException(Exception e) {
        log.error("Exception caught: ", e);
    }

}

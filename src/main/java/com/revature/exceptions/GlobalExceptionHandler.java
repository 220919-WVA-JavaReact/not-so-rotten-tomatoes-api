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

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "Login unsuccessful.")
    @ExceptionHandler(LoginException.class)
    public void handleLoginException(Exception e) {
        log.error("Exception caught: ", e);
    }
}

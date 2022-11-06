package com.revature.controllers;

import antlr.Token;
import com.revature.dtos.LoginDTO;
import com.revature.dtos.UserDTO;
import com.revature.services.AuthService;
import com.revature.services.TokenService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService as;
    private TokenService ts;

    public AuthController(AuthService as, TokenService ts) {
        this.as = as;
        this.ts = ts;
    }
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDTO> authenticate(@RequestBody LoginDTO login) {
        UserDTO user = as.authenticate(login);
        String token = ts.generateToken(user);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        return new ResponseEntity<>(user, headers, HttpStatus.OK);
    }


}

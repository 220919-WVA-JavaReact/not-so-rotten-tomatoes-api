package com.revature.controllers;

import com.revature.annotations.Secured;
import com.revature.dtos.Credentials;
import com.revature.dtos.UserDTO;
import com.revature.entities.Role;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService us;
    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }


    //PathVariable is used for mapping to variable given in map request
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") int id){
            UserDTO userDTO = us.getUserById(id);
            //User is found, returning userDTO Status 200
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody Credentials creds) {
        UserDTO userDTO = us.createUser(creds);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

}

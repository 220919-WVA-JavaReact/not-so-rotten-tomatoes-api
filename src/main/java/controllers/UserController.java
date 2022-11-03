package controllers;

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
public class UserController {

    private final UserService us;
    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }

    //RequestParam is used for retrieving query params
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers(@RequestParam(name="role", required = false) Role role){
        List<UserDTO> users = null;
        //If no request parms, return all users
        if (role == null) {
             users = us.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            users = us.getUsersByRole(role);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

    }

    //PathVariable is used for mapping to variable given in map request
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") int id){
            UserDTO userDTO = us.getUserById(id);
            //User is found, returning userDTO Status 200
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody Credentials creds) {
        UserDTO userDTO = us.createUser(creds);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }
}

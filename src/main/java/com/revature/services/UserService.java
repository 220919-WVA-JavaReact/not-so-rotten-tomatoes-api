package com.revature.services;

import com.revature.dtos.Credentials;
import com.revature.dtos.UserDTO;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository ur;

    @Autowired
    public UserService(UserRepository ur){
       this.ur = ur;
    }


    public UserDTO getUserById(int id) throws UserNotFoundException {
        User user = ur.findById(id).orElseThrow(() -> new UserNotFoundException());
        UserDTO userDTO = new UserDTO(user);

        return userDTO;
    }

    public UserDTO createUser(Credentials creds) {

        //Check if username exists?
        User u = ur.findUserByUsername(creds.getUsername());
        if ( u != null) {
            //throw a UsernameAlreadyTaken exception
        } else {
            User newUser = new User();
            newUser.setUsername(creds.getUsername());
            newUser.setEmail(creds.getEmail());
            newUser.setPassword(creds.getPassword());
            newUser.setRole(Role.USER);

            u = ur.save(newUser);
        }
        return new UserDTO(u);
    }
}

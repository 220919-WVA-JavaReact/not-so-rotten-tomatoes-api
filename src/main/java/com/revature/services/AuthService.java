package com.revature.services;

import com.revature.dtos.LoginDTO;
import com.revature.dtos.UserDTO;
import com.revature.entities.User;
import com.revature.repositories.exceptions.LoginException;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepository ur;
    @Autowired
    public AuthService(UserRepository ur) {
        this.ur = ur;
    }

    public UserDTO authenticate(LoginDTO login) {
        User user = ur.findUserByUsernameAndPassword(login.getUsername(), login.getPassword()).orElseThrow(() -> new LoginException());
        if (login.getUsername() != user.getUsername() && login.getPassword() != user.getPassword()) {
            //throw a LoginException
        }
        return new UserDTO(user);
    }
}

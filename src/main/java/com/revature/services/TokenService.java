package com.revature.services;

import com.revature.dtos.UserDTO;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private UserRepository ur;

    @Autowired
    public TokenService(UserRepository ur){
        this.ur = ur;
    }

    //basic information about the user that we can validate (ie id:role)
    public String generateToken(UserDTO user){
        //Not good token-- used for example only to get token validation.
        return user.getId()+":"+user.getRole();
    }

    public UserDTO extractTokenDetails(String token){

        if (token == null) {
            //Throw AuthenticationException
            throw new AuthenticationException();
        }
        String[] tokens = token.split(":");
        Integer id = Integer.valueOf(tokens[0]);
        Role role = Role.valueOf(tokens[1]);

        User user = ur.findById(id).orElseThrow(() -> new UserNotFoundException());

        if (!user.getRole().equals(role)){
            new AuthenticationException();
        }
        //validation behavior making sure the dto has the right role, otherwise throw another exception.
        return new UserDTO(user);
    }
}

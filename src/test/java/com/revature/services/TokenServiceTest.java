package com.revature.services;

import com.revature.NsrtApplication;
import com.revature.dtos.UserDTO;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes= NsrtApplication.class)
public class TokenServiceTest {

    @MockBean
    private UserRepository mockRepository;

    @Autowired
    private TokenService sut;

    @Test
    public void generateTokenExists(){
        User cory = new User();
        cory.setUser_id(2);
        cory.setRole(Role.USER);
        UserDTO newDTO = new UserDTO(cory);

        String expected = newDTO.getId()+":"+newDTO.getRole();

        String actual = sut.generateToken(newDTO);

        assertEquals(expected, actual);

    }

    @Test
    public void extractTokenDetailsWorks() {
        User cory = new User();
        cory.setUser_id(1);
        cory.setRole(Role.ADMIN);
        String token = "1:ADMIN";
        String[] tokens = token.split(":");
        Integer id = Integer.valueOf(tokens[0]);
        Role role = Role.valueOf(tokens[1]);

        Mockito.when(mockRepository.findById(id)).thenReturn(Optional.of(cory));

        UserDTO expected = new UserDTO(cory);

        UserDTO actual = sut.extractTokenDetails(token);

        assertEquals(expected, actual);
    }
}

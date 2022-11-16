package com.revature.services;

import com.revature.NsrtApplication;
import com.revature.dtos.LoginDTO;
import com.revature.dtos.UserDTO;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.exceptions.LoginException;
import com.revature.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes= NsrtApplication.class)
public class AuthServiceTest {
    @MockBean
    private UserRepository mockRepository;
    @Autowired
    private AuthService sut;
    @Test
    public void authenticateCorrect(){
        //Arrange
        User returnedUser = new User();
        returnedUser.setUser_id(1);
        returnedUser.setUsername("cory");
        returnedUser.setPassword("pass");
        returnedUser.setRole(Role.USER);

        UserDTO expected = new UserDTO();
        expected.setId(1);
        expected.setUsername("cory");
        expected.setRole(Role.USER);

        LoginDTO login = new LoginDTO();
        login.setUsername("cory");
        login.setPassword("pass");

        Mockito.when(mockRepository.findUserByUsernameAndPassword("cory", "pass")).thenReturn(Optional.of(returnedUser));
        //Act
        UserDTO actual = sut.authenticate(login);
        //Assert
        assertEquals(expected, actual);
    }
    @Test
    public void authenticateUserDoesNotExist(){
        LoginDTO login = new LoginDTO();
        login.setUsername("fakeUser");
        login.setPassword("fakePass");

        Mockito.when(mockRepository.findUserByUsernameAndPassword("fakeUser", "fakePass")).thenReturn(Optional.empty());

        assertThrows(LoginException.class, () -> sut.authenticate(login));

    }
}

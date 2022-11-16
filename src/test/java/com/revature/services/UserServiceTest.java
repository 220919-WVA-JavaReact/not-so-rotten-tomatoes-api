package com.revature.services;

import com.revature.NsrtApplication;
import com.revature.dtos.Credentials;
import com.revature.dtos.UserDTO;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.exceptions.UserNotFoundException;
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
public class UserServiceTest {

    @MockBean
    private UserRepository mockRepository; //we can specify returns for methods invoked since this is a mock

    @Autowired
    private UserService sut; //system under test

    @Test
    public void getUserByIdExists(){
        //Arrange
        User returnedUser = new User();
        returnedUser.setUser_id(1);
        returnedUser.setUsername("cory");
        returnedUser.setRole(Role.USER);
        // when sut calls findById(1), mockRepo will return an optional of returned user
        Mockito.when(mockRepository.findById(1)).thenReturn(Optional.of(returnedUser));

        UserDTO expected = new UserDTO();
        expected.setId(1);
        expected.setUsername("cory");
        expected.setRole(Role.USER);
        //Act

        UserDTO actual = sut.getUserById(1);
        //Assert

        assertEquals(expected, actual);
    }

    @Test
    public void getUserByIdDoesNotExist(){
        //Arrange
        Mockito.when(mockRepository.findById(10000000)).thenReturn(Optional.empty());
        //Act
        //Assert
        assertThrows(UserNotFoundException.class, () -> sut.getUserById(10000000));
    }

    @Test
    public void createUserTest(){
        Credentials login = new Credentials();
        login.setUsername("jimbob234");
        login.setPassword("1234");
        login.setEmail("jimmyb@gmail.com");
        User newUser = new User();
        newUser.setUsername(login.getUsername());
        newUser.setPassword(login.getPassword());
        newUser.setEmail(login.getEmail());
        newUser.setUser_id(123);
        newUser.setRole(Role.USER);
        UserDTO newDTOUser = new UserDTO(newUser);



        Mockito.when(mockRepository.findUserByUsername("jimbob234")).thenReturn(newUser);

        UserDTO expected = new UserDTO();
        expected.setId(123);
        expected.setUsername("jimbob234");
        expected.setRole(Role.USER);

        UserDTO actual = sut.createUser(login);


        assertEquals(expected, actual);

    }

}

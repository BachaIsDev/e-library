package com.bacha.libraryproject.restcontroller;

import com.bacha.libraryproject.entity.User;
import com.bacha.libraryproject.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserRestControllerTest {

    private static final int ID = 1;

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private UserRestController userRestController;

    @Test
    void getAllUsers_shouldReturnsAllUsers_whenExist(){
        List<User> users = List.of(mock(User.class), mock(User.class));
        when(userService.getAllUsers()).thenReturn(users);

        List<User> actualUsers = userRestController.getAllUsers();

        assertNotNull(actualUsers);
        assertEquals(actualUsers, users);
        verify(userService).getAllUsers();
    }

    @Test
    void getUserById_shouldReturnsUser_whenExist(){
        User user = mock(User.class);
        when(userService.getUserById(ID));

        User actualUser = userRestController.getUserById(ID);

        assertNotNull(actualUser);
        assertEquals(actualUser, user);
        verify(userService).getUserById(ID);
    }

    @Test
    void deleteUserById_shouldRemoveUser_whenExist(){
        User user = mock(User.class);

        userRestController.addNewUser(user);
        userRestController.deleteUserById(ID);

        verify(userService).deleteUserById(ID);
    }

    @Test
    void updateUser_shouldCallService_whenExist(){
        User user = mock(User.class);
        User newUser = mock(User.class);
        userRestController.addNewUser(user);

        userRestController.updateUser(newUser);

        verify(userService).saveUser(newUser);
    }

    @Test
    void addNewUser_shouldCallService(){
        User user = mock(User.class);

        userRestController.addNewUser(user);

        verify(userService).saveUser(user);
    }

}
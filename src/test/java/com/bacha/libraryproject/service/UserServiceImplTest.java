package com.bacha.libraryproject.service;

import com.bacha.libraryproject.entity.User;
import com.bacha.libraryproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private static final int ID = 1;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    void getAllUsers_shouldReturnUsers_whenExist() {
        List<User> users = List.of(mock(User.class), mock(User.class));
        when(userRepository.findAll()).thenReturn(users);

        final List<User> actualUsers = userServiceImpl.getAllUsers();

        assertNotNull(actualUsers);
        assertEquals(actualUsers, users);
        verify(userRepository).findAll();
    }

    @Test
    void getUserById_shouldCallRepo() {
        User user = mock(User.class);
        when(userRepository.findById(ID)).thenReturn(Optional.of(user));

        final User lastUser = userServiceImpl.getUserById(ID);

        assertNotNull(lastUser);
        assertEquals(lastUser, user);
        verify(userRepository).findById(ID);
    }

    @Test
    void saveUser_shouldCallRepo() {
        User user = mock(User.class);

        userServiceImpl.saveUser(user);

        verify(userRepository).save(user);
    }

    @Test
    void deleteUserById_shouldCallRepo() {
        User user = mock(User.class);

        userServiceImpl.saveUser(user);
        userServiceImpl.deleteUserById(ID);

        verify(userRepository).deleteById(ID);
    }
}
package com.bacha.libraryproject.service;

import com.bacha.libraryproject.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id);

    User saveUser(User user);

    void deleteUserById(int id);

}
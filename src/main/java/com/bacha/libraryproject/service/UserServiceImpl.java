package com.bacha.libraryproject.service;

import com.bacha.libraryproject.entity.User;
import com.bacha.libraryproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id){
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }
}

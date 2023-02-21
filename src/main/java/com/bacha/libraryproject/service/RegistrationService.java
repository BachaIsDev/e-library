package com.bacha.libraryproject.service;

import com.bacha.libraryproject.entity.Role;
import com.bacha.libraryproject.entity.Status;
import com.bacha.libraryproject.entity.User;
import com.bacha.libraryproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class RegistrationService {
    private final UserRepository userRepository;

    @Autowired
    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void register(User user){
        user.setBalance(new BigDecimal(0));
        user.setRole(Role.USER);
        user.setStatus(Status.ACTIVE);
        userRepository.save(user);
    }
}

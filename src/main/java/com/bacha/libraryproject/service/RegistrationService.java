package com.bacha.libraryproject.service;

import com.bacha.libraryproject.entity.Role;
import com.bacha.libraryproject.entity.Status;
import com.bacha.libraryproject.entity.User;
import com.bacha.libraryproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);
        user.setBalance(new BigDecimal(0));
        user.setRole(Role.ROLE_USER);
        user.setStatus(Status.ACTIVE);
        userRepository.save(user);
    }
}

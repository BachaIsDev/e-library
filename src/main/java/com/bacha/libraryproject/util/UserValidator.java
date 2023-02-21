package com.bacha.libraryproject.util;

import com.bacha.libraryproject.entity.User;
import com.bacha.libraryproject.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {


    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public UserValidator(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;

        try{
            userDetailsService.loadUserByUsername(user.getUsername());
        }catch (UsernameNotFoundException e){
            return; // user was not found, it's ok
        }

        errors.rejectValue("username", "", "User with such credentials already exists!");
    }
}

package com.bacha.libraryproject.restcontroller;

import com.bacha.libraryproject.entity.User;
import com.bacha.libraryproject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/api/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(name = "id") int id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@RequestBody @PathVariable(name = "id") int id){
        userService.deleteUserById(id);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PostMapping
    public User addNewUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}

package com.anima.socialsecuritysystem.controllers;

import com.anima.socialsecuritysystem.entities.model.User;
import com.anima.socialsecuritysystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User save(User user) {
        userService.save(user);
        return user;
    }

}

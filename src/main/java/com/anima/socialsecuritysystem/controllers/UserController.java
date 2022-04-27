package com.anima.socialsecuritysystem.controllers;

import com.anima.socialsecuritysystem.entities.model.User;
import com.anima.socialsecuritysystem.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User save(User user) {
        userService.save(user);
        return user;
    }

}

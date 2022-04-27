package com.anima.socialsecuritysystem.services;

import com.anima.socialsecuritysystem.entities.model.User;

import java.util.List;

public interface UserService {
    List<User> get();
    User save(User user);
}

package com.anima.socialsecuritysystem.services.impl;

import com.anima.socialsecuritysystem.entities.model.User;
import com.anima.socialsecuritysystem.repositories.UserRepository;
import com.anima.socialsecuritysystem.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> get() {
        return null;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}

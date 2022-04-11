package com.anima.socialsecuritysystem.services.impl;

import com.anima.socialsecuritysystem.entities.model.User;
import com.anima.socialsecuritysystem.repositories.UserRepository;
import com.anima.socialsecuritysystem.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}

package com.anima.socialsecuritysystem.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.anima.socialsecuritysystem.entities.model.User;
import com.anima.socialsecuritysystem.repositories.UserRepository;
import com.anima.socialsecuritysystem.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RequestMapping(path = "/users",
        produces = "application/json")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public Iterable<User> getUsers() {
        PageRequest page = PageRequest.of(0, 12, Sort.by("id").ascending());

        return userRepository.findAll(page).getContent();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserByID(@PathVariable("userId") Long userId) {
        Optional<User> optUser = userRepository.findById(userId);
        if (optUser.isPresent()) {
            return new ResponseEntity<>(optUser.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    @PutMapping("/{userId}")
    public User putUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PatchMapping(path = "/{userId}", consumes = "application/json")
    public User patchUser(@PathVariable("userId") Long userId, @RequestBody User patch) {
        User user = userRepository.findById(userId).get();

        if (patch.getFirstname() != null) {
            user.setFirstname(patch.getFirstname());
        }
        if (patch.getMiddlename() != null) {
            user.setMiddlename(patch.getMiddlename());
        }
        if (patch.getLastname() != null) {
            user.setLastname(patch.getLastname());
        }
        return userRepository.save(user);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("userId") Long userId) {
        try {
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {

        }
    }
}

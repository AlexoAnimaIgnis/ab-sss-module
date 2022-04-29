package com.anima.socialsecuritysystem.repositories;

import com.anima.socialsecuritysystem.entities.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findById(Long userId);

    void deleteById(Long userId);
}

package com.anima.socialsecuritysystem.repositories;

import com.anima.socialsecuritysystem.entities.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}

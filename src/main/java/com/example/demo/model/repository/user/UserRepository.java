package com.example.demo.model.repository.user;

import com.example.demo.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLoginOrEmailAndPassword(String login, String email, String password);
}

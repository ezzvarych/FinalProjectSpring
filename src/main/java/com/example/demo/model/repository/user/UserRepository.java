package com.example.demo.model.repository.user;

import com.example.demo.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * For registration, to find user with same login or email
     * @param login
     * @param email
     * @return
     */
    Optional<User> findByLoginOrEmail(String login, String email);
}

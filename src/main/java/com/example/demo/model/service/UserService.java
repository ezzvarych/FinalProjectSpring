package com.example.demo.model.service;

import com.example.demo.model.entity.user.User;
import com.example.demo.model.service.ParentService;

import java.util.Optional;

public interface UserService extends ParentService<User> {
    Optional<User> getByLoginOrEmail(String login, String email);
}

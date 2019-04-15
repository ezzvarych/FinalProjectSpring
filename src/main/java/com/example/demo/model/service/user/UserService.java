package com.example.demo.model.service.user;

import com.example.demo.model.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends ParentService<User> {
    Optional<User> getByLoginAndPassword(String login, String password);
}

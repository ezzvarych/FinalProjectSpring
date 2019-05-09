package com.example.demo.model.service;

import com.example.demo.model.entity.user.User;
import com.example.demo.model.service.ParentService;
import com.example.demo.model.service.crud.Deletable;
import com.example.demo.model.service.crud.Updatable;

import java.util.Optional;

public interface UserService extends ParentService<User>, Updatable<User>, Deletable {
    Optional<User> getByLoginOrEmail(String login, String email);
}

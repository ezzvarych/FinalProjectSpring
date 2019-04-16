package com.example.demo.exception;

import com.example.demo.model.entity.user.User;

public class RepeatedUserException extends RuntimeException {

    private User user;

    public RepeatedUserException(User user) {
        this.user = user;
    }

    @Override
    public String getMessage() {
        return "There is already a user with login " + user.getLogin()
                + " or email" + user.getPassword();
    }
}

package com.example.demo.exception;

import com.example.demo.model.entity.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RepeatedUserException extends RuntimeException {

    private User user;

    public RepeatedUserException(User user) {
        this.user = user;
    }

    @Override
    public String getMessage() {
        return "There is already a user with login " + user.getLogin()
                + " or email " + user.getEmail();
    }
}

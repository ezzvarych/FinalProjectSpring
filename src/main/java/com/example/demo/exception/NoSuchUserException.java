package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchUserException extends RuntimeException {
    private String login;
    public NoSuchUserException(String login) {
        super();
        this.login = login;
    }

    @Override
    public String getMessage() {
        return "No user with login " + login;
    }
}

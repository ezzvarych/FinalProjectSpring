package com.example.demo.exception;


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

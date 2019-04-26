package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundByIdException extends RuntimeException {

    private Class clazz;
    private long id;


    public NotFoundByIdException(Class clazz, long id) {
        this.clazz = clazz;
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Not found " + clazz.getSimpleName() + " with id " + id;
    }
}

package com.example.demo.exception;

import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<Object> handleException(RuntimeException ex, WebRequest req) {
        System.out.println("HELLO");
        return handleExceptionInternal(ex, "", new HttpHeaders(), HttpStatus.UNAUTHORIZED, req);
    }
}

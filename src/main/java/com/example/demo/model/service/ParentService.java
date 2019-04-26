package com.example.demo.model.service;

import com.example.demo.exception.NotFoundByIdException;

import java.util.List;
import java.util.Optional;

public interface ParentService<T> {
    List<T> getAll();
    T getById(long id) throws NotFoundByIdException;
    T create(T entity);
    T update(T entity);
    void delete(long id);
}

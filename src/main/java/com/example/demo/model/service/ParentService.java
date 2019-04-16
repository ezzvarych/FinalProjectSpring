package com.example.demo.model.service;

import java.util.List;
import java.util.Optional;

public interface ParentService<T> {
    List<T> getAll();
    Optional<T> getById(long id);
    void create(T entity);
    void update(T entity);
    void delete(long id);
}

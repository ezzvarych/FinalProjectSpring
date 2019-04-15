package com.example.demo.model.service.user;

import java.util.List;
import java.util.Optional;

public interface ParentService<T> {
    List<T> getAll();
    Optional<T> getById(long id);
    void create(T entity);
    void update(T entity);
    Optional<T> delete(long id);
}

package com.example.demo.model.repository.request;

import com.example.demo.model.entity.request.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findAllByManagerIsNull();
}

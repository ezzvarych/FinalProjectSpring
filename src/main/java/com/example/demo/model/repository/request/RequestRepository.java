package com.example.demo.model.repository.request;

import com.example.demo.model.entity.request.Request;
import com.example.demo.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findAllByCustomer(User customer);
    List<Request> findAllByManagerIsNull();
}

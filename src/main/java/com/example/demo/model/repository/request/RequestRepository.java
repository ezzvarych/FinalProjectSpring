package com.example.demo.model.repository.request;

import com.example.demo.model.entity.request.Request;
import com.example.demo.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

//TODO Add pagination!!!!!
public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findAllByCustomer(User customer);
    List<Request> findAllByManagerIsNull();
    List<Request> findAllByManagerIsNullAndCustomer(User customer);
}

package com.example.demo.model.repository.request;

import com.example.demo.model.entity.request.DeniedRequest;
import com.example.demo.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeniedRequestRepository extends JpaRepository<DeniedRequest, Long> {
    List<DeniedRequest> findAllByRequestCustomer(User customer);
}

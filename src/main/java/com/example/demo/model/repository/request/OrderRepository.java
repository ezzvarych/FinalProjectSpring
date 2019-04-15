package com.example.demo.model.repository.request;

import com.example.demo.model.entity.request.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByMasterIsNull();
}

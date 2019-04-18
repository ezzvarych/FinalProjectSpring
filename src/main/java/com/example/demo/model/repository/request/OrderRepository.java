package com.example.demo.model.repository.request;

import com.example.demo.model.entity.request.Order;
import com.example.demo.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByMasterIsNull();
    List<Order> findAllByMasterAndReadyIsFalse(User master);
    List<Order> findAllByRequestCustomerAndReadyIsTrue(User customer);
}

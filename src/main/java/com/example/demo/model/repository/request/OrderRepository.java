package com.example.demo.model.repository.request;

import com.example.demo.model.entity.request.Order;
import com.example.demo.model.entity.request.OrderStatus;
import com.example.demo.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByMasterIsNullAndOrderStatus(OrderStatus orderStatus);
    List<Order> findAllByMasterAndOrderStatus(User master, OrderStatus orderStatus);
    //List<Order> findAllByRequestCustomerAndReadyIsTrue(User customer);
    List<Order> findAllByRequestCustomerAndOrderStatus(User customer, OrderStatus orderStatus);
}

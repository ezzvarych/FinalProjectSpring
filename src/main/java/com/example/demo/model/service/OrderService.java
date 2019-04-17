package com.example.demo.model.service;

import com.example.demo.model.entity.request.Order;

import java.util.List;

public interface OrderService extends ParentService<Order> {
    List<Order> getWithoutMaster();
}

package com.example.demo.model.service;

import com.example.demo.model.entity.Feedback;
import com.example.demo.model.entity.request.Order;
import com.example.demo.model.entity.user.User;

import java.util.List;

public interface OrderService extends ParentService<Order> {
    List<Order> getWithoutMaster();
    List<Order> getNotReadyByMaster(User master);
    List<Order> getDoneOrdersByCustomer(User customer);
    void leaveFeedback(Feedback feedback);
}

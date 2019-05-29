package com.example.demo.model.service;

import com.example.demo.model.entity.Feedback;
import com.example.demo.model.entity.request.Order;
import com.example.demo.model.entity.user.User;
import com.example.demo.model.service.crud.Deletable;
import com.example.demo.model.service.crud.Updatable;

import java.util.List;

public interface OrderService extends ParentService<Order>, Updatable<Order>, Deletable {
    List<Order> getWithoutMaster();
    List<Order> getNotReadyByMaster(User master);
    List<Order> getDoneOrdersByCustomer(User customer);
    List<Order> getNonAcceptedCustomerOrders(User customer);
    Feedback leaveFeedback(Feedback feedback);
    Order userAcceptOrder(Order nonAcceptedOrder);
}

package com.example.demo.model.service.impl.request;

import com.example.demo.model.entity.Feedback;
import com.example.demo.model.entity.request.Order;
import com.example.demo.model.entity.user.User;
import com.example.demo.model.repository.request.FeedbackRepository;
import com.example.demo.model.repository.request.OrderRepository;
import com.example.demo.model.service.OrderService;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private FeedbackRepository feedbackRepository;

    public OrderServiceImpl(OrderRepository orderRepository, FeedbackRepository feedbackRepository) {
        this.orderRepository = orderRepository;
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public List<Order> getWithoutMaster() {
        return orderRepository.findAllByMasterIsNull();
    }

    @Override
    public List<Order> getNotReadyByMaster(User master) {
        return orderRepository.findAllByMasterAndReadyIsFalse(master);
    }

    @Override
    public List<Order> getDoneOrdersByCustomer(User customer) {
        return orderRepository.findAllByRequestCustomerAndReadyIsTrue(customer);
    }

    @Override
    public void leaveFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void create(Order entity) {
        orderRepository.save(entity);
    }

    @Override
    public void update(Order entity) {
        orderRepository.save(entity);
    }

    @Override
    public void delete(long id) {
        orderRepository.deleteById(id);
    }
}

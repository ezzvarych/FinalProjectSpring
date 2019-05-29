package com.example.demo.model.service.impl.request;

import com.example.demo.exception.NotFoundByIdException;
import com.example.demo.model.entity.Feedback;
import com.example.demo.model.entity.request.Order;
import com.example.demo.model.entity.request.OrderStatus;
import com.example.demo.model.entity.request.Request;
import com.example.demo.model.entity.user.User;
import com.example.demo.model.repository.FeedbackRepository;
import com.example.demo.model.repository.request.OrderRepository;
import com.example.demo.model.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return orderRepository.findAllByMasterIsNullAndOrderStatus(OrderStatus.ACCEPTED);
    }

    @Override
    public List<Order> getNotReadyByMaster(User master) {
        return orderRepository.findAllByMasterAndOrderStatus(master, OrderStatus.IN_PROGRESS);
    }

    @Override
    public List<Order> getDoneOrdersByCustomer(User customer) {
        return orderRepository.findAllByRequestCustomerAndOrderStatus(customer, OrderStatus.DONE);
    }

    @Override
    public List<Order> getNonAcceptedCustomerOrders(User customer) {
        return orderRepository.findAllByRequestCustomerAndOrderStatus(customer, OrderStatus.NOT_ACCEPTED);
    }

    @Override
    public Feedback leaveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Order userAcceptOrder(Order nonAcceptedOrder) {
        nonAcceptedOrder.setOrderStatus(OrderStatus.ACCEPTED);
        return orderRepository.save(nonAcceptedOrder);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundByIdException(Order.class, id));
    }

    @Override
    public Order create(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    public Order update(Order entity) {
        Order order = getById(entity.getId());
        order.setMaster(entity.getMaster());
        order.setOrderStatus(entity.getOrderStatus());
        return orderRepository.save(entity);
    }

    @Override
    public void delete(long id) {
        orderRepository.deleteById(id);
    }
}

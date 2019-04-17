package com.example.demo.model.service.impl.request;

import com.example.demo.model.entity.request.DeniedRequest;
import com.example.demo.model.entity.request.Order;
import com.example.demo.model.entity.request.Request;
import com.example.demo.model.entity.user.User;
import com.example.demo.model.repository.request.DeniedRequestRepository;
import com.example.demo.model.repository.request.OrderRepository;
import com.example.demo.model.repository.request.RequestRepository;
import com.example.demo.model.service.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    private Logger logger = LoggerFactory.getLogger(RequestServiceImpl.class);

    private RequestRepository requestRepository;
    private DeniedRequestRepository deniedRequestRepository;
    private OrderRepository orderRepository;

    public RequestServiceImpl(RequestRepository requestRepository,
                              DeniedRequestRepository deniedRequestRepository, OrderRepository orderRepository) {
        this.requestRepository = requestRepository;
        this.deniedRequestRepository = deniedRequestRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Request> getAllByCustomer(User customer) {
        return requestRepository.findAllByCustomer(customer);
    }

    @Override
    public List<Request> getAllUnhandled() {
        return requestRepository.findAllByManagerIsNull();
    }

    @Override
    public List<Request> getUnhandledByUser(User customer) {
        return requestRepository.findAllByManagerIsNullAndCustomer(customer);
    }

    @Override
    public void denyRequest(Request request, String reason) {
        DeniedRequest deniedRequest = new DeniedRequest(request, reason);
        deniedRequestRepository.save(deniedRequest);
    }

    @Override
    public void acceptRequest(Request request, int price) {
        Order order = new Order(request, price);
        orderRepository.save(order);
    }

    @Override
    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    @Override
    public Optional<Request> getById(long id) {
        return requestRepository.findById(id);
    }

    @Override
    public void create(Request entity) {
        requestRepository.save(entity);
    }

    @Override
    public void update(Request entity) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(long id) {
        requestRepository.deleteById(id);
    }
}

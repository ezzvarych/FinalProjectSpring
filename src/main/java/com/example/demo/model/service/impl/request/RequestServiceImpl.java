package com.example.demo.model.service.impl.request;

import com.example.demo.exception.NotFoundByIdException;
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

import java.util.List;

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
    public List<Request> getUnhandledByCustomer(User customer) {
        return requestRepository.findAllByManagerIsNullAndCustomer(customer);
    }

    @Override
    public void denyRequest(Request request, String reason) {
        deniedRequestRepository.save(new DeniedRequest(request, reason));
    }

    @Override
    public void acceptRequest(Request request, int price) {
        orderRepository.save(new Order(request, price));
    }

    @Override
    public List<DeniedRequest> getDeniedOfCustomer(User customer) {
        return deniedRequestRepository.findAllByRequestCustomer(customer);
    }

    @Override
    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    @Override
    public Request getById(long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new NotFoundByIdException(Request.class, id));
    }

    @Override
    public Request create(Request entity) {
        return requestRepository.save(entity);
    }

    @Override
    public Request update(Request entity) {
        return requestRepository.save(entity);
    }

    @Override
    public void delete(long id) {
        requestRepository.deleteById(id);
    }
}

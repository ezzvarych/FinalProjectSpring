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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RequestServiceImpl implements RequestService {

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
    public DeniedRequest denyRequest(Request request, String reason) {
        return deniedRequestRepository.save(new DeniedRequest(request, reason));
    }

    @Override
    public Order acceptRequest(Request request, int price) {
        return orderRepository.save(new Order(request, price));
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
        Request fromDB = getById(entity.getId());
        fromDB.setManager(entity.getManager());
        return requestRepository.save(fromDB);
    }

    @Override
    public void delete(long id) {
        if (!requestRepository.existsById(id)) {
            throw new NotFoundByIdException(Request.class, id);
        }
        requestRepository.deleteById(id);
    }
}

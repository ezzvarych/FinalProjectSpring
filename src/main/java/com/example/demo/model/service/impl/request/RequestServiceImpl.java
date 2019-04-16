package com.example.demo.model.service.impl.request;

import com.example.demo.model.entity.request.Request;
import com.example.demo.model.entity.user.User;
import com.example.demo.model.repository.request.RequestRepository;
import com.example.demo.model.service.RequestService;

import java.util.List;
import java.util.Optional;

//TODO Add implementation
public class RequestServiceImpl implements RequestService {

    private RequestRepository requestRepository;

    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public List<Request> getAllByCustomer(User customer) {
        return requestRepository.findAllByCustomer(customer);
    }

    @Override
    public List<Request> getAll() {
        return null;
    }

    @Override
    public Optional<Request> getById(long id) {
        return Optional.empty();
    }

    @Override
    public void create(Request entity) {

    }

    @Override
    public void update(Request entity) {

    }

    @Override
    public void delete(long id) {
        requestRepository.deleteById(id);
    }
}

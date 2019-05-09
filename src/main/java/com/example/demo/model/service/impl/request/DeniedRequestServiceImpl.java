package com.example.demo.model.service.impl.request;

import com.example.demo.exception.NotFoundByIdException;
import com.example.demo.model.entity.request.DeniedRequest;
import com.example.demo.model.entity.request.Request;
import com.example.demo.model.entity.user.User;
import com.example.demo.model.repository.request.DeniedRequestRepository;
import com.example.demo.model.repository.request.RequestRepository;
import com.example.demo.model.service.DeniedRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DeniedRequestServiceImpl implements DeniedRequestService {

    private DeniedRequestRepository deniedRequestRepository;
    private RequestRepository requestRepository;


    public DeniedRequestServiceImpl(DeniedRequestRepository deniedRequestRepository, RequestRepository requestRepository) {
        this.deniedRequestRepository = deniedRequestRepository;
        this.requestRepository = requestRepository;
    }

    @Override
    public List<DeniedRequest> getDeniedOfCustomer(User customer) {
        return deniedRequestRepository.findAllByRequestCustomer(customer);
    }

    @Override
    public List<DeniedRequest> getAll() {
        return deniedRequestRepository.findAll();
    }

    @Override
    public DeniedRequest getById(long id) throws NotFoundByIdException {
        return deniedRequestRepository.findById(id).orElseThrow(() -> new NotFoundByIdException(DeniedRequest.class, id));
    }

    @Override
    public DeniedRequest create(DeniedRequest entity) {
        return deniedRequestRepository.save(entity);
    }
}

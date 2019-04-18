package com.example.demo.model.service;

import com.example.demo.model.entity.request.Request;
import com.example.demo.model.entity.user.User;

import java.util.List;

public interface RequestService extends ParentService<Request>, DeniedRequestService {
    List<Request> getAllByCustomer(User customer);
    List<Request> getAllUnhandled();
    List<Request> getUnhandledByCustomer(User customer);
    void denyRequest(Request request, String reason);
    void acceptRequest(Request request, int price);
}

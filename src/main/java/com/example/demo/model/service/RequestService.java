package com.example.demo.model.service;

import com.example.demo.model.entity.request.Request;
import com.example.demo.model.entity.user.User;

import java.util.List;

public interface RequestService extends ParentService<Request> {
    List<Request> getAllByCustomer(User customer);
}

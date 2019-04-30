package com.example.demo.model.service;

import com.example.demo.model.entity.request.DeniedRequest;
import com.example.demo.model.entity.request.Request;
import com.example.demo.model.entity.user.User;

import java.util.List;

public interface DeniedRequestService extends ParentService<DeniedRequest> {
    List<DeniedRequest> getDeniedOfCustomer(User customer);
}

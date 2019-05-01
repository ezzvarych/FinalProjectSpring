package com.example.demo.controller.restController;

import com.example.demo.controller.viewsContoller.UserSupportUtils;
import com.example.demo.model.entity.request.DeniedRequest;
import com.example.demo.model.entity.request.Order;
import com.example.demo.model.entity.request.Request;
import com.example.demo.model.service.DeniedRequestService;
import com.example.demo.model.service.OrderService;
import com.example.demo.model.service.RequestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
@PreAuthorize("hasAuthority('CUSTOMER')")
public class RequestRestController {

    private RequestService requestService;
//    private DeniedRequestService deniedRequestService;
//    private OrderService orderService;


    public RequestRestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public ResponseEntity<Request> createRequest(@RequestBody String description) {
        Request request = new Request(description, UserSupportUtils.getCurrentUser());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(requestService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<Request>> getRequests() {
        return ResponseEntity.ok(requestService.getAll());
    }

    @GetMapping("/unhandled")
    public ResponseEntity<List<Request>> getCustomerUnhandled() {
        return ResponseEntity.ok(requestService.getUnhandledByCustomer(UserSupportUtils.getCurrentUser()));
    }


}

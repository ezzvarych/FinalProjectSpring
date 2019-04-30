package com.example.demo.controller.restController;

import com.example.demo.controller.viewsContoller.UserSupportUtils;
import com.example.demo.model.entity.request.Request;
import com.example.demo.model.entity.user.Role;
import com.example.demo.model.entity.user.User;
import com.example.demo.model.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO Secure methods(one user cannot get requests of another)
@RestController
@RequestMapping("/customer/requests")
@PreAuthorize("hasAuthority('CUSTOMER')")
public class RequestRestController {

    private RequestService requestService;

    public RequestRestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public ResponseEntity<Request> createRequest(@RequestBody String description) {
        Request request = new Request(description, UserSupportUtils.getCurrentUser());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(requestService.create(request));
    }

    @GetMapping("/")
    public ResponseEntity<List<Request>> getRequests() {
        return ResponseEntity.ok(requestService.getAllByCustomer(UserSupportUtils.getCurrentUser()));
    }

    @GetMapping("/unhandled")
    public ResponseEntity<List<Request>> getCustomerUnhandled() {
        return ResponseEntity.ok(requestService.getUnhandledByCustomer(UserSupportUtils.getCurrentUser()));
    }

    @GetMapping("/denied")
    public ResponseEntity<List<Request>> getCustomerDenied() {
        return ResponseEntity.ok(requestService.getUnhandledByCustomer(UserSupportUtils.getCurrentUser()));
    }

}

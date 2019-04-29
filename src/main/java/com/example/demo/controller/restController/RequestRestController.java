package com.example.demo.controller.restController;

import com.example.demo.controller.viewsContoller.UserSupportUtils;
import com.example.demo.model.entity.request.Request;
import com.example.demo.model.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TODO Finish this controller
@RestController
@RequestMapping("/requests")
public class RequestRestController {

    private RequestService requestService;

    public RequestRestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public ResponseEntity<Request> createRequest(String description) {
        Request request = new Request(description, UserSupportUtils.getCurrentUser());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(requestService.create(request));
    }

//    @GetMapping("/unhandled/{id}")
//    public ResponseEntity<Request> getCustomerUnhandled(@PathVariable long id) {
//
//    }

}

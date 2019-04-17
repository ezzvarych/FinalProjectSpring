package com.example.demo.controller;

import com.example.demo.model.entity.request.Request;
import com.example.demo.model.entity.user.User;
import com.example.demo.model.entity.user.UserPrincipal;
import com.example.demo.model.service.RequestService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private RequestService requestService;

    public CustomerController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public ModelAndView getRequests() {
//        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = userPrincipal.getUser();
        return new ModelAndView("/customer/customer-requests",
                "requests", requestService.getUnhandledByUser(getCurrentUser()));
    }

    @GetMapping("/new-request")
    public String newRequestForm() {
        return "/customer/new-request";
    }

    @PostMapping("/new-request")
    public String addNewRequest(@RequestParam String descr) {
        Request request = new Request(descr, getCurrentUser());
        requestService.create(request);
        return "redirect:/customer";
    }

    private User getCurrentUser() {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userPrincipal.getUser();
        return user;
    }
}

package com.example.demo.controller;

import com.example.demo.model.entity.user.User;
import com.example.demo.model.entity.user.UserPrincipal;
import com.example.demo.model.repository.request.RequestRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private RequestRepository requestRepository;

    public CustomerController(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @GetMapping("/requests")
    public ModelAndView getRequests() {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userPrincipal.getUser();
     //   System.out.println(requestRepository.findAllByCustomer(user));
        return new ModelAndView("/customer/customer-requests",
                "requests", requestRepository.findAllByCustomer(user));
    }

}

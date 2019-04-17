package com.example.demo.controller;

import com.example.demo.model.entity.request.Request;
import com.example.demo.model.entity.user.UserPrincipal;
import com.example.demo.model.service.RequestService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private RequestService requestService;

    public ManagerController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping()
    public ModelAndView getUnhandled() {
        return new ModelAndView("/manager/manager-requests",
                "requests", requestService.getAllUnhandled());
    }

    @GetMapping("/deny/{request}")
    public ModelAndView denyRequestForm(@PathVariable Request request) {
        return new ModelAndView("/manager/deny-form", "request", request);
    }

    @PostMapping("/deny/{request}")
    public String denyRequest(@PathVariable Request request, @RequestParam String reason) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        request.setManager(userPrincipal.getUser());
        requestService.denyRequest(request, reason);
        return "redirect:/manager";
    }

    @GetMapping("/accept/{request}")
    public ModelAndView acceptRequestForm(@PathVariable Request request) {
        return new ModelAndView("/manager/accept-form", "request", request);
    }

    @PostMapping("/accept/{request}")
    public String acceptRequest(@PathVariable Request request, @RequestParam int price) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        request.setManager(userPrincipal.getUser());
        requestService.acceptRequest(request, price);
        return "redirect:/manager";
    }
}

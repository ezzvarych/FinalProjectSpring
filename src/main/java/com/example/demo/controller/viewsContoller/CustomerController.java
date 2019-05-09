package com.example.demo.controller.viewsContoller;

import com.example.demo.model.entity.Feedback;
import com.example.demo.model.entity.request.Order;
import com.example.demo.model.entity.request.Request;
import com.example.demo.model.service.DeniedRequestService;
import com.example.demo.model.service.OrderService;
import com.example.demo.model.service.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private RequestService requestService;
    private OrderService orderService;
    private DeniedRequestService deniedRequestService;

    public CustomerController(RequestService requestService, OrderService orderService, DeniedRequestService deniedRequestService) {
        this.requestService = requestService;
        this.orderService = orderService;
        this.deniedRequestService = deniedRequestService;
    }

    @GetMapping
    public ModelAndView getRequests() {
        return new ModelAndView("/customer/customer-requests",
                "requests",
                requestService.getUnhandledByCustomer(UserSupportUtils.getCurrentUser()));
    }

    @GetMapping("/new-request")
    public String newRequestForm() {
        return "/customer/new-request";
    }

    @PostMapping("/new-request")
    public String addNewRequest(@RequestParam String descr) {
        Request request = new Request(descr, UserSupportUtils.getCurrentUser());
        requestService.create(request);
        return "redirect:/customer";
    }

    @GetMapping("/denied")
    public ModelAndView getDenied() {
        return new ModelAndView("/customer/denied",
                "deniedRequests", deniedRequestService.getDeniedOfCustomer(UserSupportUtils.getCurrentUser()));
    }

    @GetMapping("/done")
    public ModelAndView getDoneOrders() {
        return new ModelAndView("/customer/get-done",
                "doneOrders", orderService.getDoneOrdersByCustomer(UserSupportUtils.getCurrentUser()));
    }

    @PostMapping("/left-feedback/{order}")
    public String leftFeedback(@PathVariable Order order, @RequestParam String feedback) {
        Feedback feed = new Feedback(feedback, order);
        orderService.leaveFeedback(feed);
        return "redirect:/customer";
    }
}

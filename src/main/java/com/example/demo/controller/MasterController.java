package com.example.demo.controller;

import com.example.demo.model.entity.request.Order;
import com.example.demo.model.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/master")
public class MasterController {

    private OrderService orderService;

    public MasterController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ModelAndView getWithoutMaster() {
        return new ModelAndView("/master/orders",
                "orders", orderService.getWithoutMaster());
    }

    @PostMapping("/take/{order}")
    public ModelAndView orderTaken(@PathVariable Order order) {
        return null;
    }
}

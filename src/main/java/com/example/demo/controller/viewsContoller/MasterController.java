package com.example.demo.controller.viewsContoller;

import com.example.demo.model.entity.Model;
import com.example.demo.model.entity.request.Order;
import com.example.demo.model.service.InstructionService;
import com.example.demo.model.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/master")
public class MasterController {

    private OrderService orderService;
    private InstructionService instructionService;

    public MasterController(OrderService orderService, InstructionService instructionService) {
        this.orderService = orderService;
        this.instructionService = instructionService;
    }

    @GetMapping
    public ModelAndView getWithoutMaster() {
        return new ModelAndView("/master/orders",
                "orders", orderService.getWithoutMaster());
    }

    @PostMapping("/take/{order}")
    public String orderTaken(@PathVariable Order order) {
        order.setMaster(UserSupportUtils.getCurrentUser());
        orderService.update(order);
        return "redirect:/master/my-orders";
    }

    @GetMapping("/my-orders")
    public ModelAndView getMasterOrders() {
        List<Order> orders = orderService.getNotReadyByMaster(UserSupportUtils.getCurrentUser());
        return new ModelAndView("/master/not-ready-orders", "orders", orders);
    }

    @PostMapping("/done/{order}")
    public String orderDone(@PathVariable Order order) {
        order.setReady(true);
        orderService.update(order);
        return "redirect:/master";
    }

    @GetMapping("/instructions")
    public ModelAndView getMasterInstructions() {
        return new ModelAndView("/master/instructions",
                "instr", instructionService.getAllForMaster(UserSupportUtils.getCurrentUser()));
    }
}

package com.example.demo.controller.restController;

import com.example.demo.controller.viewsContoller.UserSupportUtils;
import com.example.demo.model.dto.AcceptRequestDTO;
import com.example.demo.model.entity.Feedback;
import com.example.demo.model.entity.request.Order;
import com.example.demo.model.entity.request.OrderStatus;
import com.example.demo.model.entity.request.Request;
import com.example.demo.model.service.OrderService;
import com.example.demo.model.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    private OrderService orderService;
    private RequestService requestService;

    public OrderRestController(OrderService orderService, RequestService requestService) {
        this.orderService = orderService;
        this.requestService = requestService;
    }

    @PreAuthorize("hasAuthority('MASTER')")
    @GetMapping
    public ResponseEntity<List<Order>> getAllUnhandled() {
        return ResponseEntity.ok(orderService.getWithoutMaster());
    }

    @GetMapping("/user/done")
    public ResponseEntity<List<Order>> getCustomerDoneOrders() {
        return ResponseEntity.ok(orderService
                .getDoneOrdersByCustomer(UserSupportUtils.getCurrentUser()));
    }

    @GetMapping("/master")
    public ResponseEntity<List<Order>> getMasterCurrOrders() {
        return ResponseEntity.ok(orderService
                .getNotReadyByMaster(UserSupportUtils.getCurrentUser()));
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @PostMapping
    public ResponseEntity<Order> acceptRequest(@RequestBody AcceptRequestDTO dto) {
        Request request = requestService.getById(dto.getRequestId());
        request.setManager(UserSupportUtils.getCurrentUser());
        Order order = new Order(request, dto.getPrice());
        return new ResponseEntity<>(orderService.create(order), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('MASTER')")
    @PutMapping("/{id}")
    public ResponseEntity<Order> takeOrder(@PathVariable long id) {
        Order order = orderService.getById(id);
        if (order.getMaster() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        order.setMaster(UserSupportUtils.getCurrentUser());
        return new ResponseEntity<>(orderService.create(order), HttpStatus.CONTINUE);
    }

    @PreAuthorize("hasAuthority('MASTER')")
    @PutMapping("/{id}/done")
    public ResponseEntity<Order> doneOrder(@PathVariable long id) {
        Order order = orderService.getById(id);
        if (order.getOrderStatus() == OrderStatus.DONE) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else if (!order.getMaster().getId()
                .equals(UserSupportUtils.getCurrentUser().getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        order.setOrderStatus(OrderStatus.DONE);
        return ResponseEntity.status(HttpStatus.CONTINUE)
                .body(orderService.create(order));
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @PutMapping("/{order}/feedback")
    public ResponseEntity<Feedback> leaveFeedback(@PathVariable Order order, @RequestBody String feedbackStr) {
        if (order.getFeedback().getFeedbackStr() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (!order.getRequest().getCustomer().getId()
                .equals(UserSupportUtils.getCurrentUser().getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        Feedback feedback = new Feedback(feedbackStr, order);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.leaveFeedback(feedback));
    }
}

package com.example.demo.controller.restController;

import com.example.demo.controller.viewsContoller.UserSupportUtils;
import com.example.demo.model.dto.DenyRequestDTO;
import com.example.demo.model.entity.request.DeniedRequest;
import com.example.demo.model.entity.request.Request;
import com.example.demo.model.service.DeniedRequestService;
import com.example.demo.model.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/denied")
@Slf4j
public class DeniedRequestRestController {

    private DeniedRequestService deniedRequestService;
    private RequestService requestService;

    public DeniedRequestRestController(DeniedRequestService deniedRequestService, RequestService requestService) {
        this.deniedRequestService = deniedRequestService;
        this.requestService = requestService;
    }

//    @PreAuthorize("hasAuthority('MANAGER')")
//    @PostMapping
//    public ResponseEntity<DeniedRequest> denyRequest(@RequestBody DenyRequestDTO dto) {
//        Request request = requestService.getById(dto.getRequestId());
//        request.setManager(UserSupportUtils.getCurrentUser());
//
//        DeniedRequest deniedRequest = new DeniedRequest(request, dto.getDenyReason());
//        return new ResponseEntity<>(deniedRequestService.create(deniedRequest), HttpStatus.CREATED);
//    }

    @GetMapping
    public ResponseEntity<List<DeniedRequest>> getCustomerDenied() {
        return ResponseEntity.ok(deniedRequestService.getDeniedOfCustomer(UserSupportUtils.getCurrentUser()));
    }
}

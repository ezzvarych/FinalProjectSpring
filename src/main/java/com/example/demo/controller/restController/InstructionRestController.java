package com.example.demo.controller.restController;

import com.example.demo.controller.viewsContoller.UserSupportUtils;
import com.example.demo.model.entity.Instruction;
import com.example.demo.model.repository.InstructionRepository;
import com.example.demo.model.service.InstructionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/instructions")
public class InstructionRestController {
    private InstructionService instructionService;

    public InstructionRestController(InstructionService instructionService) {
        this.instructionService = instructionService;
    }

    @GetMapping("/master")
    public ResponseEntity<List<Instruction>> getInstructionsForMaster() {
        return ResponseEntity.ok(instructionService.getAllForMaster(UserSupportUtils.getCurrentUser()));
    }
}

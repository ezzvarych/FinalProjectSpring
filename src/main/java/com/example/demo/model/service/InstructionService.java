package com.example.demo.model.service;

import com.example.demo.model.entity.Instruction;
import com.example.demo.model.entity.user.User;

import java.util.List;

public interface InstructionService extends ParentService<Instruction> {
    List<Instruction> getAllForMaster(User master);
}

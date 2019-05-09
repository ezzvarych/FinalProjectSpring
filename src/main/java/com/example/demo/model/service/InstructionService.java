package com.example.demo.model.service;

import com.example.demo.model.entity.Instruction;
import com.example.demo.model.entity.user.User;
import com.example.demo.model.service.crud.Deletable;
import com.example.demo.model.service.crud.Updatable;

import java.util.List;

public interface InstructionService extends ParentService<Instruction>, Updatable<Instruction>, Deletable {
    List<Instruction> getAllForMaster(User master);
}

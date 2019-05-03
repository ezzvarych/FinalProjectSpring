package com.example.demo.model.service.impl;

import com.example.demo.exception.NotFoundByIdException;
import com.example.demo.model.entity.Instruction;
import com.example.demo.model.entity.Region;
import com.example.demo.model.entity.user.User;
import com.example.demo.model.repository.InstructionRepository;
import com.example.demo.model.service.InstructionService;
import com.example.demo.model.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class InstructionServiceImpl implements InstructionService {

    private InstructionRepository instructionRepository;

    public InstructionServiceImpl(InstructionRepository instructionRepository) {
        this.instructionRepository = instructionRepository;
    }

    @Override
    public List<Instruction> getAll() {
        return instructionRepository.findAll();
    }

    @Override
    public Instruction getById(long id) throws NotFoundByIdException {
        return instructionRepository.findById(id)
                .orElseThrow(() -> new NotFoundByIdException(Instruction.class, id));
    }

    @Override
    public Instruction create(Instruction entity) {
        return null;
    }

    @Override
    public Instruction update(Instruction entity) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(long id) {
        if (!instructionRepository.existsById(id)) {
            throw new NotFoundByIdException(Instruction.class, id);
        }
        instructionRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<Instruction> getAllForMaster(User master) {
        return instructionRepository
                .findDistinctByAllowedRegionsIn(master.getMasterAllowedRegions());
    }
}

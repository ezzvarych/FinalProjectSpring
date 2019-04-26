package com.example.demo.model.repository;

import com.example.demo.model.entity.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructionRepository extends JpaRepository<Instruction, Long> {
}

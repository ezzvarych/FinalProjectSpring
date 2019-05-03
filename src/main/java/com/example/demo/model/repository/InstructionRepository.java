package com.example.demo.model.repository;

import com.example.demo.model.entity.Instruction;
import com.example.demo.model.entity.Region;
import com.example.demo.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface InstructionRepository extends JpaRepository<Instruction, Long> {
    //@Query("select instr from instruction instr where instr.allowedRegions in :allowedRegions")
    //List<Instruction> findAllAllowedInRegions(Set<Region> allowedRegions);
    List<Instruction> findDistinctByAllowedRegionsIn(Set<Region> allowedRegions);
}

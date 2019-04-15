package com.example.demo.model.repository.user;

import com.example.demo.model.entity.user.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}

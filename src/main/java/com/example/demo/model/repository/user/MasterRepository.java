package com.example.demo.model.repository.user;

import com.example.demo.model.entity.user.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepository extends JpaRepository<Master, Long> {
}

package com.example.demo.model.repository.request;

import com.example.demo.model.entity.request.DeniedRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeniedRequestRepository extends JpaRepository<DeniedRequest, Long> {

}

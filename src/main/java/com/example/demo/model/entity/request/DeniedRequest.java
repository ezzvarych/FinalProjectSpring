package com.example.demo.model.entity.request;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class DeniedRequest extends Request {

    @Column(nullable = false, updatable = false)
    private String denyReason;
}

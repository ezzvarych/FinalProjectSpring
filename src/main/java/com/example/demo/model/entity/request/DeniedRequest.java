package com.example.demo.model.entity.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class DeniedRequest {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Request request;

    @Column(nullable = false, updatable = false)
    private String denyReason;

    public DeniedRequest(Request request, String denyReason) {
        this.request = request;
        this.denyReason = denyReason;
    }
}

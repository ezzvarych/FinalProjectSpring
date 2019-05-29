package com.example.demo.model.entity.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//TODO Delete this entity, useless
@Data
@NoArgsConstructor
@Entity
public class DeniedRequest {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id")
    @MapsId
    private Request request;

    public DeniedRequest(Request request) {
        this.request = request;
    }

    //    @Column(nullable = false, updatable = false)
//    private String denyReason;
//
//    public DeniedRequest(Request request, String denyReason) {
//        this.request = request;
//        this.denyReason = denyReason;
//    }
}

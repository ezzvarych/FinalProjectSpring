package com.example.demo.model.entity;

import com.example.demo.model.entity.request.Order;

import javax.persistence.*;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 511)
    private String feedback;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

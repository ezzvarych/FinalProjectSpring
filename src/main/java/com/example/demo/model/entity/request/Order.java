package com.example.demo.model.entity.request;

import com.example.demo.model.entity.Feedback;
import com.example.demo.model.entity.user.Master;
import com.example.demo.model.entity.user.User;

import javax.persistence.*;

@Entity
@Table(name = "det_order")
public class Order extends Request {

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "master_id")
    private Master master;

    private boolean isReady;

    @OneToOne(mappedBy = "order")
    private Feedback feedback;
}

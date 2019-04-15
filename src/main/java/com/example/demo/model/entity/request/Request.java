package com.example.demo.model.entity.request;

import com.example.demo.model.entity.user.Customer;
import com.example.demo.model.entity.user.Manager;
import com.example.demo.model.entity.user.User;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descr", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    private Date date;
}

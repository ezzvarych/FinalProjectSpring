package com.example.demo.model.entity.request;

import com.example.demo.model.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descr", nullable = false)
    private String description;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    private Date date;
}

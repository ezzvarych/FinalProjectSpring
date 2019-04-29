package com.example.demo.model.entity.request;

import com.example.demo.model.entity.user.User;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

    private Date date = new Date(System.currentTimeMillis());

    @OneToOne(mappedBy = "request")
    private DeniedRequest deniedRequest;

    @OneToOne(mappedBy = "request")
    private Order order;

    public Request(String description, User customer) {
        this.description = description;
        this.customer = customer;
    }
}

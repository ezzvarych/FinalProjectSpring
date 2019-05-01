package com.example.demo.model.entity.request;

import com.example.demo.model.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
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

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private User customer;

    @ToString.Exclude
    @ManyToOne()
    @JoinColumn(name = "manager_id")
    private User manager;

    private Date date = new Date(System.currentTimeMillis());

//    @JsonIgnore
//    @OneToOne(mappedBy = "request", optional = false, fetch = FetchType.LAZY)
//    private DeniedRequest deniedRequest;

//    @JsonIgnore
//    @OneToOne(mappedBy = "request", fetch = FetchType.LAZY)
//    private Order order;

    public Request(String description, User customer) {
        this.description = description;
        this.customer = customer;
    }
}

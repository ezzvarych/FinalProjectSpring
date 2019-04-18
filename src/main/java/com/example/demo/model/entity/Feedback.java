package com.example.demo.model.entity;

import com.example.demo.model.entity.request.Order;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Feedback {
    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 511)
    private String feedback;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Feedback(String feedback, Order order) {
        this.feedback = feedback;
        this.order = order;
    }
}

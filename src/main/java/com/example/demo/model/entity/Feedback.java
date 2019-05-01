package com.example.demo.model.entity;

import com.example.demo.model.entity.request.Order;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Feedback {
    @EqualsAndHashCode.Exclude
    @Id
    private Long id;

    @Column(nullable = false, length = 511)
    private String feedbackStr;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Order order;

    public Feedback(String feedbackStr, Order order) {
        this.feedbackStr = feedbackStr;
        this.order = order;
    }
}

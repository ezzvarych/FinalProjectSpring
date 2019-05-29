package com.example.demo.model.entity.request;

import com.example.demo.model.entity.Feedback;
import com.example.demo.model.entity.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Order entity, order = accepted by manager request
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "det_order")
public class Order {

    /**
     * Primary key, shared with request!!!!
     */
    @Id
    private Long id;

    /**
     * Request, related to this order, contain a shared primary key
     */
    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Request request;

    /**
     * Order price, is set by manager who accept request
     */
    @Column(nullable = false)
    private int price;

    /**
     * Master, who does current order,
     * master to order relationship -> one to many
     */
    @ManyToOne
    @JoinColumn(name = "master_id")
    private User master;

    private Timestamp orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.NOT_ACCEPTED;

    /**
     * Feedback by customer about work, master or something else
     */
    @OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
    private Feedback feedback;

    public Order(Request request, int price) {
        this.request = request;
        this.price = price;
    }

    /**
     * To create entity manually
     * @param request - accepted by manager request
     * @param price - order price
     */

    public Order(Request request, int price, Timestamp date) {
        this.request = request;
        this.price = price;
        this.orderDate = date;
    }
}

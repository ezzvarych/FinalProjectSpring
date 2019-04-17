package com.example.demo.model.entity.request;

import com.example.demo.model.entity.Feedback;
import com.example.demo.model.entity.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    private boolean isReady;

    /**
     * Feedback by customer about work, master or something else
     */
    @OneToOne(mappedBy = "order")
    private Feedback feedback;

    /**
     * To create entity manually
     * @param request - accepted by manager request
     * @param price - order price
     */
    public Order(Request request, int price) {
        this.request = request;
        this.price = price;
    }
}

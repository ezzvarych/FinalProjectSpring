package com.example.demo.model.entity.user;

import com.example.demo.model.entity.request.Order;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("3")
public class Master extends User {
    @OneToMany(mappedBy = "master")
    private List<Order> masterOrders;

    @Builder
    public Master(String login, String email, String password) {
        super(login, email, password, Role.MASTER);
    }
}

package com.example.demo.model.entity.user;

import com.example.demo.model.entity.request.Request;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("1")
public class Customer extends User {

    @OneToMany(mappedBy = "customer")
    private List<Request> customerRequests;

//    @Builder
//    public Customer(String login, String email, String password) {
//        super(login, email, password, Role.CUSTOMER);
//    }
}

package com.example.demo.model.entity.user;

import com.example.demo.model.entity.request.DeniedRequest;
import com.example.demo.model.entity.request.Order;
import com.example.demo.model.entity.request.Request;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class User {
    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false, length = 64)
    private String login;

    @Column(unique = true, length = 128)
    private String email;

    @EqualsAndHashCode.Exclude
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "customer")
    private List<Request> customerRequests;

    @OneToMany(mappedBy = "manager")
    private List<Request> managerRequests;

    @OneToMany(mappedBy = "manager")
    private List<DeniedRequest> managerDeniedRequests;

    @OneToMany(mappedBy = "master")
    private List<Order> masterOrders;

    public User(String login, String email, String password, Role role) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}

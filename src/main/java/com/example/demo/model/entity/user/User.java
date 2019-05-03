package com.example.demo.model.entity.user;

import com.example.demo.model.entity.Region;
import com.example.demo.model.entity.request.Order;
import com.example.demo.model.entity.request.Request;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * User entity, consist all authorized users in application
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class User {
    /**
     * Primary key
     */
    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false, length = 64)
    private String login;

    @Column(unique = true, length = 128)
    @JsonIgnore
    private String email;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @Column(nullable = false)
    private String password;

    /**
     * User role, important for security
     */
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * Contain all user as customer requests about repairing
     */
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Request> customerRequests;

    /**
     * To map manager that handle request with request
     */
    @JsonIgnore
    @OneToMany(mappedBy = "manager")
    private List<Request> managerRequests;

    /**
     * Map master who take orders with this orders
     */
    @JsonIgnore
    @OneToMany(mappedBy = "master")
    private List<Order> masterOrders;

    @JsonIgnore
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Region> masterAllowedRegions;

    public User(String login, String email, String password, Role role) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}

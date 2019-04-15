package com.example.demo.model.entity.user;

import com.example.demo.model.entity.request.DeniedRequest;
import com.example.demo.model.entity.request.Request;
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
@DiscriminatorValue("2")
public class Manager extends User {

    @OneToMany(mappedBy = "manager")
    List<Request> managerRequests;

    @OneToMany(mappedBy = "manager")
    List<DeniedRequest> managerDeniedRequests;

    @Builder
    public Manager(String login, String email, String password) {
        super(login, email, password, Role.MANAGER);
    }
}

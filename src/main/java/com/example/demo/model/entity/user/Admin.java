package com.example.demo.model.entity.user;

import lombok.Builder;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

    @Builder
    public Admin(String login, String email, String password) {
        super(login, email, password, Role.ADMIN);
    }
}

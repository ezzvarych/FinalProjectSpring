package com.example.demo.model.entity.user;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.EnumSet;
import java.util.stream.Collectors;

public enum Role implements GrantedAuthority {
    UNKNOWN, CUSTOMER, MANAGER, MASTER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }

    public Collection<GrantedAuthority> getAuthorities() {
        EnumSet<Role> allRoles = EnumSet.allOf(Role.class);
        return allRoles.stream()
                .filter(role1 -> role1.ordinal() <= this.ordinal())
                .collect(Collectors.toSet());
    }
}

package com.example.demo.model.entity.user;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.EnumSet;
import java.util.stream.Collectors;

/**
 * All possible user role in application,
 * implements GrantedAuthority to use it for SpringSecurity
 * configuration
 */
public enum Role implements GrantedAuthority {
    CUSTOMER, MANAGER, MASTER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }

    public Collection<GrantedAuthority> getAuthorities() {
        EnumSet<Role> allRoles = EnumSet.allOf(Role.class);
        if (this == Role.MASTER) {
            return allRoles.stream()
                    .filter(role1 -> role1.ordinal() <= this.ordinal())
                    .collect(Collectors.toSet());
        }
        return allRoles.stream()
                .filter(role1 -> role1.ordinal() <= this.ordinal() && role1 != Role.MASTER)
                .collect(Collectors.toSet());
    }
}

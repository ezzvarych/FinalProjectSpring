package com.example.demo.model.entity.user;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * For security, save current user in session
 */
public class UserPrincipal implements UserDetails {

    private Logger logger = LoggerFactory.getLogger(UserPrincipal.class);
    /**
     * Real user entity from db
     */
    @Getter
    private User user;

    public UserPrincipal(User user) {
        this.user = user;
        logger.info(getAuthorities().toString());
    }

    /**
     * User authorities(whose authorities has user)
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRole().getAuthorities();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

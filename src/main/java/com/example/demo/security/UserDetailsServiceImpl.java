package com.example.demo.security;

import com.example.demo.model.entity.user.User;
import com.example.demo.model.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * For security purposes(authorization)
 */
@Service("userDetails")
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getByLoginOrEmail(login, login)
                .orElseThrow(() -> new UsernameNotFoundException("Such user not found"));
        return new UserPrincipal(user);
    }

}

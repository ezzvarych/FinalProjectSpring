package com.example.demo.model.service.impl.user;

import com.example.demo.model.entity.user.User;
import com.example.demo.model.entity.user.UserPrincipal;
import com.example.demo.model.repository.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * For security purposes(authorization)
 */
@Service("userDetails")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLoginOrEmail(login, login);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Such user not found");
        }
        return new UserPrincipal(user.get());
    }
}

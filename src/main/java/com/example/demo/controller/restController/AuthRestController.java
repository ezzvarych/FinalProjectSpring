package com.example.demo.controller.restController;

import com.example.demo.model.dto.UserLoginDTO;
import com.example.demo.model.entity.user.User;
import com.example.demo.model.service.UserService;
import com.example.demo.security.UserPrincipal;
import com.example.demo.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

@RestController
@RequestMapping("/auth/login")
public class AuthRestController {

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;

    @Qualifier("userDetails")
    @Autowired
    private UserDetailsService userDetailsService;

    public AuthRestController(AuthenticationManager authenticationManager,
                              JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping
    public ResponseEntity<Properties> loginProcess(@RequestBody UserLoginDTO userLoginDTO) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userLoginDTO.getLogin(), userLoginDTO.getPassword()));

        UserDetails userDetails = userDetailsService.loadUserByUsername(userLoginDTO.getLogin());
        String jwtToken = jwtTokenProvider.createToken(userDetails);

        Properties properties = new Properties();
        properties.setProperty("username", userDetails.getUsername());
        properties.setProperty("token", jwtToken);

        return ResponseEntity.ok(properties);
    }
}
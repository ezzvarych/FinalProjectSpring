package com.example.demo.model.repository.user;

import com.example.demo.model.entity.user.Role;
import com.example.demo.model.entity.user.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        User user = User.builder()
                .login("user")
                .password("user")
                .role(Role.CUSTOMER)
                .build();
        userRepository.save(user);
        assertEquals(userRepository.findByLoginOrEmail("user", "user").get(), user);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testSave_RepeatedException() {
        User user = User.builder()
                .login("user1")
                .password("user")
                .role(Role.CUSTOMER)
                .build();
        userRepository.save(user);
    }

    @Test
    public void testUpdate() {
        User user = User.builder()
                .id(1L)
                .login("user123")
                .password("user")
                .role(Role.CUSTOMER)
                .build();
        userRepository.save(user);
        assertEquals(userRepository.findByLoginOrEmail("user123", "u").get(), user);
    }
}
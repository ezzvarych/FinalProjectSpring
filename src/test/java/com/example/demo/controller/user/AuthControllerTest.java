package com.example.demo.controller.user;

import com.example.demo.model.repository.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AuthControllerTest {

    private MockMvc mockMvc;
    private UserRepository userRepository;

    public AuthControllerTest(MockMvc mockMvc, UserRepository userRepository) {
        this.mockMvc = mockMvc;
        this.userRepository = userRepository;
    }

    @Test
    public void mainPage() {
    }

    @Test
    public void getRegistrationForm() {
    }

    //TODO Find out why no get method inside perform
    @Test
    public void handleRegistration() {
        //mockMvc.perform();
    }

    @Test
    public void exceptionHandler() {
    }
}
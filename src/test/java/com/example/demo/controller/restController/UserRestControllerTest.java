package com.example.demo.controller.restController;

import com.example.demo.model.entity.user.Role;
import com.example.demo.model.entity.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserRestControllerTest {

    @Rule
    private Timeout timeout = Timeout.seconds(1);

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void saveTest() throws Exception {
        User user = User.builder()
                .login("user2")
                .email("zhenya.zvarych@gmail.com")
                .password("user2")
                .role(Role.CUSTOMER)
                .build();

        String json = objectMapper.writeValueAsString(user);

        this.mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    public void saveTest_repeated_exception() throws Exception {
        User user = User.builder()
                .login("user1")
                .email("zhenya.zvarych@gmail.com")
                .password("user2")
                .role(Role.CUSTOMER)
                .build();

        String json = objectMapper.writeValueAsString(user);

        this.mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateTest() throws Exception {
        User user = User.builder()
                .login("user1")
                .email("zhenya.zvarych@gmail.com")
                .password("user2")
                .role(Role.CUSTOMER)
                .build();

        String json = objectMapper.writeValueAsString(user);
        this.mockMvc.perform(post("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isNoContent());
    }
}

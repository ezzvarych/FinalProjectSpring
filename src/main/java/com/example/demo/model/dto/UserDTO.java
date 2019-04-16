package com.example.demo.model.dto;

import com.example.demo.model.entity.user.Role;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    private String fullName;

    @NotNull
    @Size(min = 5, max = 30, message = "This login is not appropriate")
    private String login;

    @Email
    private String email;

    @NotNull
    @Size(min = 5, max = 30)
    private String password;

    private Role role;
}

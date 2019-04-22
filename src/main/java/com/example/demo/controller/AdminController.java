package com.example.demo.controller;

import com.example.demo.model.entity.user.Role;
import com.example.demo.model.entity.user.User;
import com.example.demo.model.service.RequestService;
import com.example.demo.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView getUsers() {
        return new ModelAndView("/admin/main", "users", userService.getAll());
    }

    @GetMapping("/change-role/{user}")
    public ModelAndView changeRolePage(@PathVariable User user) {
        return new ModelAndView("/admin/change-role", "user", user);
    }

    @PostMapping("/change-role/{user}")
    public String changeRole(@PathVariable User user, @RequestParam Role role) {
        user.setRole(role);
        userService.update(user);
        return "redirect:/admin";
    }
}

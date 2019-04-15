package com.example.demo.controller.user;

import com.example.demo.model.entity.user.User;
import com.example.demo.model.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/")
//    public ModelAndView mainPage(@RequestParam String login) {
//        Optional<User> user = userService.getByLoginAndPassword(login, login);
//        if (!user.isPresent()) {
//            System.out.println("No such element");
//            return null;
//        }
//        return new ModelAndView("index", "user", user.get());
//    }
}

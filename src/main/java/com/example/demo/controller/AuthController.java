package com.example.demo.controller;

import com.example.demo.exception.NoSuchUserException;
import com.example.demo.exception.RepeatedUserException;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.model.entity.user.User;
import com.example.demo.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Controller that handles registration and login requests
 */
@Controller
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    /**
     * User service for operations with user
     */
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/")
//    public ModelAndView mainPage(@RequestParam String login) {
//        Optional<User> user = userService.getByLoginOrEmail(login, login);
//        if (!user.isPresent()) {
//            throw new NoSuchUserException(login);
//        }
//        return new ModelAndView("index", "user", user.get());
//    }

    /**
     * Throw forward to registration page with UserDTO object
     * @return
     */
    @GetMapping("/register")
    public ModelAndView getRegistrationForm() {
        return new ModelAndView("registration", "userDTO", new UserDTO());
    }

    /**
     * Handle registration, if invalid input - return to registration page,
     * else - register user redirect to login page
     * @param userDTO
     * @param bindingResult
     * @return
     */
    @PostMapping("/register")
    public String handleRegistration(@Valid UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.create(getUserFromDTO(userDTO));
        return "redirect:/login";
    }

    @GetMapping("/login")
    public ModelAndView getLoginForm() {
        return new ModelAndView("login", "userDTO", new UserDTO());
    }

    /**
     * Private method that turn UserDTO entity in User
     * @param userDTO
     * @return
     */
    private User getUserFromDTO(UserDTO userDTO) {
        return User.builder().fullName(userDTO.getFullName())
                .login(userDTO.getLogin())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .role(userDTO.getRole())
                .build();
    }

    /**
     * Handle RepeatedUserException
     * @param exception
     * @return
     */
    @ExceptionHandler(RepeatedUserException.class)
    public ModelAndView userIsPresentException(RepeatedUserException exception) {
        logger.warn("Attempt to add existed user!");
        return new ModelAndView("registration", "exc", exception.getMessage());
    }

    @ExceptionHandler(NoSuchUserException.class)
    public ModelAndView exceptionHandler(NoSuchUserException exception) {
        logger.warn("Page is not found!!!");
        return new ModelAndView("error", "exc", exception.getMessage());
    }

}

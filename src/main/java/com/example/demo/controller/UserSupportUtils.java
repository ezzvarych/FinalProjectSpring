package com.example.demo.controller;

import com.example.demo.model.entity.user.User;
import com.example.demo.model.entity.user.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Useful staff in controller executing
 */
class UserSupportUtils {
    static User getCurrentUser() {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userPrincipal.getUser();
        return user;
    }
}

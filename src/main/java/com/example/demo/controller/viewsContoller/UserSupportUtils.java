package com.example.demo.controller.viewsContoller;

import com.example.demo.model.entity.user.User;
import com.example.demo.security.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Useful staff in controller executing
 */
public class UserSupportUtils {
    public static User getCurrentUser() {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userPrincipal.getUser();
        return user;
    }
}

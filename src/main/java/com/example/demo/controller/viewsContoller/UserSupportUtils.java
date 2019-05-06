package com.example.demo.controller.viewsContoller;

import com.example.demo.model.entity.user.Role;
import com.example.demo.model.entity.user.User;
import com.example.demo.security.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Useful staff in controller executing
 */
public class UserSupportUtils {
    public static User getCurrentUser() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userPrincipal.getUser();
        return user;
    }
}

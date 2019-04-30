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
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userPrincipal.getUser();
        return user;
    }

//    public static UserDetails getCurrentUserDetails() {
//        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    }
//
//    public static boolean hasRights(User user) {
//        return user.getId().equals(getCurrentUser().getId())
//                || getCurrentUserDetails().getAuthorities().contains(Role.ADMIN);
//    }
}

package com.gmail.zagurskaya.service.Util;

import com.gmail.zagurskaya.service.UserService;
import com.gmail.zagurskaya.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserUtil {
    private final UserService userService;

@Autowired
    public UserUtil(UserService userService) {
        this.userService = userService;
    }


    public UserDTO getActualUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        UserDTO user = userService.loadUserByUsername(name);
        return user;
    }
}

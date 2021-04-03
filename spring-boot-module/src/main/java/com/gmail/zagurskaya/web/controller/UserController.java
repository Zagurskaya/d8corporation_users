package com.gmail.zagurskaya.web.controller;

import com.gmail.zagurskaya.service.RoleService;
import com.gmail.zagurskaya.service.UserService;
import com.gmail.zagurskaya.service.Util.UserUtil;
import com.gmail.zagurskaya.service.model.RoleDTO;
import com.gmail.zagurskaya.service.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.gmail.zagurskaya.web.constant.URLConstant.PATH_USER_USER;
import static com.gmail.zagurskaya.web.constant.URLConstant.PATH_USER_USERS;
import static com.gmail.zagurskaya.web.constant.URLConstant.URL_USER;
import static com.gmail.zagurskaya.web.constant.URLConstant.URL_ADMINISTRATOR_EXIT;
import static com.gmail.zagurskaya.web.constant.URLConstant.URL_USERS;

@Controller
@RequestMapping(URL_USER)
public class UserController {
    private final UserService userService;
    private final RoleService roleService;
    private final UserUtil userUtil;


    public UserController(UserService userService, RoleService roleService, UserUtil userUtil) {
        this.userService = userService;
        this.roleService = roleService;
        this.userUtil = userUtil;
    }

    @GetMapping
    public String getAdminPage(Model model) {
        UserDTO user = userUtil.getActualUser();
        String FullName = user.getFullName();
        model.addAttribute("FullName", FullName);
        return PATH_USER_USER;
    }

    @GetMapping(URL_USERS)
    public String getUsersInAdminPage(Model model) {
        List<UserDTO> users = userService.getUsers();
        List<RoleDTO> roles = roleService.getRoles();
        model.addAttribute("users", users);
        model.addAttribute("roles", roles);
        return PATH_USER_USERS;
    }

    @GetMapping(URL_ADMINISTRATOR_EXIT)
    public String getExitPage() {
        return "/";
    }
}

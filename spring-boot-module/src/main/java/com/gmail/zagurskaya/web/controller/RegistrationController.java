package com.gmail.zagurskaya.web.controller;

import com.gmail.zagurskaya.service.UserService;
import com.gmail.zagurskaya.service.Util.UserUtil;
import com.gmail.zagurskaya.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static com.gmail.zagurskaya.web.constant.URLConstant.*;


@Controller
@RequestMapping(URL_REGISTRATION)
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegistrationPage(Model model) {
        return PATH_REGISTRATION;
    }

    @PostMapping()
    public String postAddUserInAdminPage(@ModelAttribute(value = "user") @Valid UserDTO userDTO,
                                         Model model) {
        userService.add(userDTO);
        return PATH_USER_REDIRECT;
    }
}

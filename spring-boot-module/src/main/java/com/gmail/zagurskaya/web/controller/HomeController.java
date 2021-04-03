package com.gmail.zagurskaya.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String getHomePage() {

        return "home";
    }

    @GetMapping("/login")
    public String getLoginPage() {

        return "login";
    }
    @GetMapping("/login?logout")
    public String getLogOutPage() {
		
        return "/";
    }

    @GetMapping("/about")
    public String getAboutPage() {

        return "about";
    }
    @GetMapping("/403")
    public String get403Page() {

        return "403";
    }
}

package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";  // looks for login.html in templates folder
    }
}

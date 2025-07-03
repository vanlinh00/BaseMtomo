package com.example.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OAuth2User principal) {
        // Google returns "name", "email", "sub" (user ID), etc.
        return "Hello, " + principal.getAttribute("name") + " (" + principal.getAttribute("email") + ")";
    }
}

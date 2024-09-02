package com.company.controller;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProfile {
    @GetMapping("/profile")
    public String userProfile(Model model, Principal principal) {
        if (principal instanceof OAuth2User) {
            OAuth2User oauth2User = (OAuth2User) principal;
            model.addAttribute("name", oauth2User.getAttribute("name"));
            model.addAttribute("email", oauth2User.getAttribute("email"));
        }
        return "profile";
    }
}

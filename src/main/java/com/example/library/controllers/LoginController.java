package com.example.library.controllers;

import com.example.library.services.LoggedUserManagementService;
import com.example.library.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;
    private final LoggedUserManagementService loggedUserManagementService;

    public LoginController(LoginService loginService, LoggedUserManagementService loggedUserManagementService){
        this.loginService = loginService;
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/")
    public String home(){
        return "login";
    }

    @PostMapping("/")
    public String login(@RequestParam String username,
                        @RequestParam String password, Model model){
        loginService.setUsername(username);
        loginService.setPassword(password);
        boolean loggedIn = loginService.loginGet();

        if(loggedIn){
            loggedUserManagementService.setUsername(loginService.getUsername());
            return "redirect:/books";
        }

        model.addAttribute("message", "Login Failed!");
        return "login";
    }


}

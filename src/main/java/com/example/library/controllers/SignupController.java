package com.example.library.controllers;

import com.example.library.model.UserCredential;
import com.example.library.repositories.UserCredentialsDB;
import com.example.library.services.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {
    private final UserCredentialsDB userCredentialsDB;
    private final LoggedUserManagementService loggedUserManagementService;

    public SignupController(UserCredentialsDB userCredentialsDB, LoggedUserManagementService loggedUserManagementService){
        this.userCredentialsDB = userCredentialsDB;
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/signup")
    public String home(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username,
                         @RequestParam String password, Model model){

        if(userCredentialsDB.checkExistingUser(username)){
            model.addAttribute("message", "Account already exists");
        }else {
            UserCredential userCredential = new UserCredential(username, password);
            userCredentialsDB.addUser(userCredential);
            loggedUserManagementService.setUsername(userCredential.getUsername());
            return "redirect:/books";
        }
        return "signup";
    }

}

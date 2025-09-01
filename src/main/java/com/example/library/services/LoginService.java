package com.example.library.services;

import com.example.library.repositories.UserCredentialsDB;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Objects;

@Service
@RequestScope
public class LoginService {
    private String username;
    private String password;
    private final UserCredentialsDB userCredentialsDB;

    public LoginService(UserCredentialsDB userCredentialsDB){
        this.userCredentialsDB = userCredentialsDB;
    }

    public boolean loginGet(){
        String username = this.getUsername();
        String password = this.getPassword();

        if(userCredentialsDB.checkExistingUser(username)){
            return Objects.equals(userCredentialsDB.findAll().get(username), password);
        }else {
            return false;
        }
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

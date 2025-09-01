package com.example.library.repositories;

import com.example.library.model.UserCredential;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;

@Repository
@ApplicationScope
public class UserCredentialsDB {
    private final HashMap<String, String> userCredentials = new HashMap<>();

    public void addUser(UserCredential userCredential){
        userCredentials.put(userCredential.getUsername(), userCredential.getPassword());
    }

    public HashMap<String, String> findAll(){
        return userCredentials;
    }

    public boolean checkExistingUser(String username){
        return userCredentials.containsKey(username);
    }
}

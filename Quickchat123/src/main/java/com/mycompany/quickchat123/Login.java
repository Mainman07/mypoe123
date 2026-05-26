/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat123;

/**
 *
 * @author Student
 */

import java.util.regex.Pattern;

public class Login {

    private String username;
    private String password;

    // Constructor
    public Login(String username,
                 String password) {

        this.username = username;
        this.password = password;
    }

    // Username validation
    public boolean checkUserName() {

        return username.contains("_")&& username.length() <= 5;
    }

    // Password validation
    public boolean checkPasswordComplexity() {

        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$";

        return Pattern.matches(regex, password);
    }

    // Register user
    public String registerUser() {

        if (!checkUserName()) {

            return "Username is incorrectly formatted.";
        }

        if (!checkPasswordComplexity()) {

            return "Password is incorrectly formatted.";
        }

        return "User registered successfully.";
    }

    // Login validation
    public boolean loginUser(String enteredUsername, String enteredPassword) {

        return enteredUsername.equals(username)&& enteredPassword.equals(password);
    }
}
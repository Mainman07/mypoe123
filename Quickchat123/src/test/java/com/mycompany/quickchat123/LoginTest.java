/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.quickchat123;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author student
 */


public class LoginTest {

    // =========================
    // VALID USERNAME
    // =========================
    @Test
    public void testValidUsername() {

        Login login =
                new Login("kyl_1","Password1!");

        boolean result = login.checkUserName();

        assertTrue(result);
    }

    // =========================
    // INVALID USERNAME
    // =========================
    @Test
    public void testInvalidUsername() {

        Login login =new Login( "kyle123", "Password1!");

        boolean result =login.checkUserName();

        assertFalse(result);
    }

    // =========================
    // VALID PASSWORD
    // =========================
    @Test
    public void testValidPassword() {

        Login login = new Login( "kyl_1", "Password1!");

        boolean result = login.checkPasswordComplexity();

        assertTrue(result);
    }

    // =========================
    // INVALID PASSWORD
    // =========================
    @Test
    public void testInvalidPassword() {

        Login login = new Login( "kyl_1", "password");

        boolean result =login.checkPasswordComplexity();

        assertFalse(result);
    }

    // =========================
    // LOGIN SUCCESS
    // =========================
    @Test
    public void testLoginSuccess() {

        Login login =new Login( "kyl_1", "Password1!");

        boolean result = login.loginUser("kyl_1", "Password1!");

        assertTrue(result);
    }

    // =========================
    // LOGIN FAILURE
    // =========================
    @Test
    public void testLoginFailure() {

        Login login = new Login( "kyl_1","Password1!");

        boolean result = login.loginUser( "wrong","wrong");

        assertFalse(result);
    }
}
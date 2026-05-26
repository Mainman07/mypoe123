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


public class Quickchat123Test {

    // =========================
    // TEST REGISTRATION SUCCESS
    // =========================
    @Test
    public void testRegistrationSuccess() {

        Login login =
                new Login(
                        "kyl_1",
                        "Password1!");

        String result =
                login.registerUser();

        assertEquals(
                "User registered successfully.",
                result);
    }

    // =========================
    // TEST LOGIN SUCCESS
    // =========================
    @Test
    public void testLoginSuccess() {

        Login login =
                new Login(
                        "kyl_1",
                        "Password1!");

        boolean result =
                login.loginUser(
                        "kyl_1",
                        "Password1!");

        assertTrue(result);
    }

    // =========================
    // TEST LOGIN FAILURE
    // =========================
    @Test
    public void testLoginFailure() {

        Login login =
                new Login(
                        "kyl_1",
                        "Password1!");

        boolean result =
                login.loginUser(
                        "wrong",
                        "wrong");

        assertFalse(result);
    }

    // =========================
    // TEST VALID MESSAGE
    // =========================
    @Test
    public void testValidMessage() {

        Message message =
                new Message(
                        "+27831234567",
                        "Hello");

        assertTrue(
                message.checkRecipientCell());

        assertTrue(
                message.checkMessageLength());
    }

    // =========================
    // TEST INVALID RECIPIENT
    // =========================
    @Test
    public void testInvalidRecipient() {

        Message message =
                new Message(
                        "0831234567",
                        "Hello");

        assertFalse(
                message.checkRecipientCell());
    }

    // =========================
    // TEST INVALID MESSAGE LENGTH
    // =========================
    @Test
    public void testInvalidMessageLength() {

        String longMessage =
                "A".repeat(260);

        Message message =
                new Message(
                        "+27831234567",
                        longMessage);

        assertFalse(
                message.checkMessageLength());
    }
}

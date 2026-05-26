/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.quickchat123;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    // =========================
    // VALID RECIPIENT NUMBER
    // =========================
    @Test
    public void testValidRecipientNumber() {

        Message message =  new Message("+27831234567","Hello");

        boolean result = message.checkRecipientCell();

        assertTrue(result);
    }

    // =========================
    // INVALID RECIPIENT NUMBER
    // =========================
    @Test
    public void testInvalidRecipientNumber() {

        Message message = new Message( "+27831234567", "Hello");

        boolean result = message.checkRecipientCell();

        assertFalse(result);
    }

    // =========================
    // VALID MESSAGE LENGTH
    // =========================
    @Test
    public void testValidMessageLength() {

        Message message = new Message("+27831234567", "Hello World");

        boolean result =message.checkMessageLength();

        assertTrue(result);
    }

    // =========================
    // INVALID MESSAGE LENGTH
    // =========================
    @Test
    public void testInvalidMessageLength() {

        String longMessage = "A".repeat(260);

        Message message =new Message("+27831234567",longMessage);

        boolean result = message.checkMessageLength();

        assertFalse(result);
    }
}
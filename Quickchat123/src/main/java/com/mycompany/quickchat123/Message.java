/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat123;

/**
 *
 * @author student
 */

import java.util.Random;

public class Message {

    private static int totalMessages = 0;

    private String recipient;
    private String message;
    private String messageID;

    // Constructor
    public Message(String recipient, String message) {

        this.recipient = recipient;
        this.message = message;

        generateMessageID();
    }

    // Generate random ID
    private void generateMessageID() {

        Random random = new Random();

        int number = 100000000 + random.nextInt(900000000);

        messageID = String.valueOf(number);
    }

    // Check recipient number
    public boolean checkRecipientCell() {

    String regex = "^\\+27\\d{9}$";

    return recipient.matches(regex);
    }

    // Check message length
    public boolean checkMessageLength() {

        return message.length() <= 250;
    }

    // Send message
    public void sendMessage() {

        totalMessages++;

        System.out.println("Message sent successfully.");
    }

    // Display message
    public void printMessageDetails() {

        System.out.println("\nMessage ID: " + messageID);

        System.out.println("Recipient: " + recipient);

        System.out.println("Message: " + message);
    }

    // Total sent messages
    public static int returnTotalMessages() {

        return totalMessages;
    }
}
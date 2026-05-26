/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat123;

/**
 *
 * @author Student
 */

import java.util.Scanner;

public class Quickchat123 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Login registeredUser = null;

        boolean running = true;

        while (running) {

            System.out.println("=== QUICKCHAT ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Quit");


            System.out.print("Choose option: ");

            int option = input.nextInt();
            input.nextLine();

            switch (option) {

                // =========================
                // REGISTER
                // =========================
                case 1 -> {

                    System.out.print(
                            "Create Username: ");

                    String username =input.nextLine();

                    System.out.print(
                            "Create Password: ");

                    String password = input.nextLine();

                    registeredUser = new Login(username, password);

                    String result = registeredUser.registerUser();

                    System.out.println(result);
                }

                // =========================
                // LOGIN
                // =========================
                case 2 -> {

                    // Check if user registered
                    if (registeredUser == null) {

                        System.out.println("Please register first.");

                        break;
                    }

                    System.out.print("Enter Username: ");

                    String enteredUsername = input.nextLine();

                    System.out.print("Enter Password: ");

                    String enteredPassword =input.nextLine();

                    boolean loginStatus = registeredUser.loginUser( enteredUsername,enteredPassword);

                    if (loginStatus) {

                        System.out.println("\nWelcome to QuickChat.");

                        // =========================
                        // QUICKCHAT MENU
                        // =========================
                        boolean loggedIn = true;

                        while (loggedIn) {

                            System.out.println("""
                                    
                                    === QUICKCHAT MENU ===
                                    
                                    1. Send Messages
                                    2. Show Recently Sent Messages
                                    3. Quit QuickChat
                                    """);

                            System.out.print( "Choose option: ");

                            int quickOption =input.nextInt();

                            input.nextLine();

                            switch (quickOption) {

                                // =========================
                                // SEND MESSAGES
                                // =========================
                                case 1 -> {

                                    System.out.print("How many messages would you like to send? ");

                                    int total =input.nextInt();

                                    input.nextLine();

                                    for (int i = 1;i <= total;i++) {

                                        System.out.println("\nMessage " + i);

                                        String recipient;
                                        while(true){
                                            System.out.print("Enter the recipient number: ");
                                            recipient = input.nextLine();
                                            if (recipient.matches("^\\+27\\d{9}$")){
                                                break;
                                            }
                                            System.out.println("Invalid number, try again");
                                        }

                                        System.out.print("Enter Message: ");

                                        String messageText =input.nextLine();

                                        Message message = new Message(recipient, messageText);

                                        // Validate recipient
                                        if (!message.checkRecipientCell()) {

                                            System.out.println( "Invalid recipient number.");

                                            continue;
                                        }

                                        // Validate length
                                        if (!message.checkMessageLength()) {

                                            System.out.println( "Message exceeds 250 characters.");

                                            continue;
                                        }

                                        // Send message
                                        message.sendMessage();

                                        // Display details
                                        message.printMessageDetails();
                                    }

                                    System.out.println("\nTotal Messages Sent: "+ Message.returnTotalMessages());
                                }

                                // =========================
                                // RECENTLY SENT
                                // =========================
                                case 2 -> {

                                    System.out.println("Coming Soon.");
                                }

                                // =========================
                                // QUIT QUICKCHAT
                                // =========================
                                case 3 -> {

                                    System.out.println("Exiting QuickChat...");

                                    loggedIn = false;
                                }

                                default -> {

                                    System.out.println("Invalid option.");
                                }
                            }
                        }
                    }

                    else {

                        System.out.println("Username or password incorrect.");
                    }
                }

                // =========================
                // QUIT PROGRAM
                // =========================
                case 3 -> {

                    System.out.println("Program Closed.");

                    running = false;
                }

                default -> {

                    System.out.println( "Invalid option.");
                }
            }
        }
    }
}

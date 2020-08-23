package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class BankApplication {
    public static void main(String args[]) throws FileNotFoundException {
        // Unrealistic example: several bank accounts added into a list
        /*BankAccount bankAccount = new BankAccount("John", "Doe", "jdoe75");
        BankAccount bankAccount1 = new BankAccount("Johnny", "Doe", "jjdo52");
        BankAccount bankAccount2 = new BankAccount("Jenny", "Doe", "jed12");
        BankAccountList acclist = new BankAccountList();
        acclist.addBankAccount(bankAccount);
        acclist.addBankAccount(bankAccount1);
        acclist.addBankAccount(bankAccount2);*/

        Scanner input = new Scanner(System.in);

        // TODO: Pass filename as argument to program. Can this be done with just `file_reader.Next()`?
        // String filename = input.next();
        final String filename = "accounts.txt";

        Scanner file_reader = new Scanner(new File(filename));

        BankAccountList accounts = new BankAccountList(new HashSet<BankAccount>());
        //BankAccountList accounts = BankAccountList.read(file_reader);
        //PrintWriter file_write = new PrintWriter(filename);

        int user_choice;
        boolean login_valid = true;
        boolean loop_valid = false;
        double input_amount = 0;

        while(login_valid) {
            // TODO: is resetting variables here necessary? remove/let it be?
            input_amount = 0;
            user_choice = 0;

            // Login menu
            System.out.println("Welcome! \n" +
                    "1. Login\n" +
                    "2. Register\n" +
                    "3. About\n" +
                    "4. Print banks\n" +
                    "0. Quit\n" +
                    "Enter your choice: ");
            user_choice = input.nextInt();
            switch (user_choice) {
                case 1:
                    // TODO: Login here and edit your account settings
                    break;
                case 2:
                    String input_name = "";
                    String input_surname = "";
                    String input_username = "";
                    //double balance = 0;

                    clearScreen();
                    System.out.println("Welcome to the registration section!");
                    System.out.print("What is your name?: ");
                    input.nextLine();
                    input_name = input.nextLine();
                    System.out.print("What is your surname?: ");
                    input_surname = input.nextLine();
                    System.out.print("What would you want your username to be?");
                    input_username = input.nextLine();

                    BankAccount acc = new BankAccount(input_name, input_surname, input_username, 0.0);
                    System.out.println("Account created! Here are the details:");
                    System.out.println(acc.toString());
                    slightDelay();
                    accounts.addBankAccount(acc);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println(accounts.toString());
                    slightDelay();
                    break;
                case 5:
                    //System.out.println(acclist.toString());
                    break;
                case 0:
                    System.out.println("Quitting..");
                    login_valid = false;
                    break;
                default:
                    clearScreen();
                    System.out.println("Not a valid choice!");
                    slightDelay();
                    break;
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void slightDelay() {
        try {
            Thread.sleep(3000);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}

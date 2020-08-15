package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Bank bank = new Bank();
        Scanner in = new Scanner(System.in);
        int user_choice;
        boolean loop_valid = true;
        float balance = 0f;

        // Main program start
        while(loop_valid) {
            bank.menu_print();
            user_choice = in.nextInt();
            System.out.println("Your input was: " + user_choice);
            switch (user_choice) {
                // Deposit money
                case 1:
                    bank.Deposit(in);
                    break;
                // Withdraw money
                case 2:
                    bank.Withdraw(in);
                    break;
                // Check balance
                case 3:
                    bank.showBalance();
                    break;
                // Quit
                case 0:
                    System.out.println("Quitting..");
                    loop_valid = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}

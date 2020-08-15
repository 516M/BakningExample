package com.company;
import java.util.Scanner;

public class Bank {
    private float balance;

    // TODO: will this be a collection of balances, instead of one balance? One balance = One bank account?
    public Bank() {
        this.balance = 0;
    }
    // TODO: Method: Create new balance. balance will have its own ID?

    public void Deposit(Scanner input) {
        System.out.print("Please enter amount to deposit: ");
        float amount = input.nextFloat();
        if (amount <= 0) {
            System.out.println("ERROR: Bad amount has been given!");
        } else {
            addBalance(amount);
            System.out.println("$"+amount+" has been added to your balance.");
        }
    }

    public void Withdraw(Scanner input) {
        System.out.print("Please enter the amount to withdraw: ");
        float amount = input.nextFloat();
        if (amount <= 0 || amount > this.balance) {
            System.out.println("ERROR: Bad amount has been given!");
        } else {
            subBalance(amount);
            System.out.println("$"+amount+" has been withdrawn from your balance.");
        }
    }

    public void addBalance(float amount) {
        this.balance += amount;
    }

    public void subBalance(float amount) {
        this.balance -= amount;
    }

    public float getBalance() {
        return this.balance;
    }

    // TODO: add options here?
    public void showBalance() {
        System.out.println("Your balance currently stands at :\n" +
                "$"+getBalance()+" .");
    }

    // TODO: save balances to a file with a structure?

    public static void menu_print() {
        System.out.println("1. Deposit money");
        System.out.println("2. Withdraw money");
        System.out.println("3. Check balance");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
    }
}

package com.company;


import java.util.Scanner;

public class BankAccount {
    private String name;
    private String surname;
    //private String password;
    private String username;
    private double balance;
    // TODO: generate a 'bank account number' with RNG?

    public BankAccount(String name, String surname, String username, double balance) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.balance = balance;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getUsername() {
        return this.username;
    }

    public void depositMoney(double amount) {
        if (amount <= 0) {
            System.out.println("ERROR: Bad amount has been given!");
        } else {
            addBalance(amount);
            System.out.println("$"+amount+" has been added to your balance.");
        }
    }

    public void withdrawMoney(double amount) {
        if (amount <= 0 || amount > this.balance) {
            System.out.println("ERROR: Bad amount has been given!");
        } else {
            subBalance(amount);
            System.out.println("$"+amount+" has been withdrawn from your balance.");
        }
    }

    // TODO: do checks on values for the methods below. methods below should return either true or false (to signify validation of values)
    public boolean addBalance(double amount) {
        this.balance += amount;
        return true;
    }

    public boolean subBalance(double amount) {
        this.balance -= amount;
        return true;
    }

    public double getBalance() {
        return this.balance;
    }

    // TODO: add options here? Or is just the bank account's toString gonna be used?
    public void showBalance() {
        System.out.println("Your balance currently stands at :\n" +
                "$"+getBalance()+" .");
    }

    @Override
    public String toString() {
        return  "Account holder Name and Surname: " + getName() + " " + getSurname() + "\n" + "Current balance: $" +
        Double.toString(getBalance()) + " dollars" + "\n" + "Account holder username: " + getUsername();
    }

    public static BankAccount read(Scanner given_input) {
        given_input.useDelimiter(",");
        String username = given_input.next();
        String name = given_input.next();
        String surname = given_input.next();
        given_input.nextLine();
        double balance = given_input.nextDouble();
        return new BankAccount(name, surname, username, balance);
    }
    // TODO: Create read from file and write to file methods
}

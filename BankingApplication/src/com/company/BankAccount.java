package com.company;


import java.util.Objects;
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
    public String showBalance() {
        return "Your balance currently stands at :\n" +
                "$"+getBalance()+" .";
    }

    @Override
    public String toString() {
        return  "Account holder Name and Surname: " + getName() + " " + getSurname() + "\n" + "Current balance: $" +
        Double.toString(getBalance()) + " dollars" + "\n" + "Account holder username: " + getUsername();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return Double.compare(that.getBalance(), getBalance()) == 0 &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getSurname(), that.getSurname()) &&
                Objects.equals(getUsername(), that.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getUsername(), getBalance());
    }

    public static BankAccount read(Scanner given_input) {
        given_input.useDelimiter(",");
        String username = given_input.next().trim();
        String name = given_input.next().trim();
        String surname = given_input.next().trim();
        given_input.nextLine();
        String balance = given_input.next();
        return new BankAccount(name, surname, username, Double.parseDouble(balance));
    }

    public String printFormatted() {
        return this.username + ", " + this.name + ", " + this.surname + ", \n" + this.balance + ",";
    }

}

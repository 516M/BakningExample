package com.company;

import java.io.*;
import java.util.Scanner;

public class ATMApplication {
    public static void main(String[] args) throws FileNotFoundException {
        final String filename = args[0];

        Scanner input = new Scanner(System.in);
        Scanner file_reader = new Scanner(new File(filename));
        BankAccountList accounts = BankAccountList.read(file_reader);

        int user_choice;
        boolean found_user = false;
        String input_username;
        boolean login_valid = true;
        boolean loop_valid;
        double input_amount;

        while(login_valid) {
            // Login menu
            System.out.print("(Type 0 and press enter to quit the program)" +
                    "\nPlease enter your username to login: ");
            input_username = input.next();

            if (input_username.equals("0")) {
                login_valid = false;
            }

            for (BankAccount account : accounts.getBankAccountList()) {
                found_user = false;
                if (account.getUsername().equals(input_username)) {
                    found_user = true;
                    System.out.println("Welcome, "+account.getName());

                        loop_valid = true;
                        while(loop_valid) {
                            System.out.print("What do you want to do?" +
                                    "\n1. Withdraw money" +
                                    "\n2. Deposit money" +
                                    "\n3. Check balance" +
                                    "\n4. Quit" +
                                    "\nEnter your choice: ");
                            user_choice = input.nextInt();

                            switch (user_choice) {
                                case 1 -> {
                                    System.out.println("Withdrawal" +
                                            "\n How much to withdraw: ");
                                    input_amount = input.nextDouble();
                                    account.withdrawMoney(input_amount);
                                    saveToFile(accounts, filename, accounts.printFormatted());
                                }
                                case 2 -> {
                                    System.out.println("Deposit" +
                                            "\n How much to deposit: ");
                                    input_amount = input.nextDouble();
                                    account.depositMoney(input_amount);
                                    saveToFile(accounts, filename, accounts.printFormatted());
                                }
                                case 3 -> System.out.println(account.showBalance());
                                case 4 -> {
                                    System.out.println("Bye!");
                                    loop_valid = false;
                                }
                                default -> System.out.println("Invalid choice.");
                            }
                        }
                        break;
                }
            }
            if (!found_user && !input_username.equals("0")) {
                System.out.println("This user does not exist!");
            }
        }
        saveToFile(accounts, filename, accounts.printFormatted());
        System.out.println("Quitting..");
    }

    public static void saveToFile(BankAccountList accounts,
                           String filename,
                           String save) throws FileNotFoundException {
        if (!accounts.isEmpty()) {
            System.out.println("Saving changes..");
            FileWriter file_writer = null;
            try {
                file_writer = new FileWriter(filename);
                // TODO: save files with an order!
                file_writer.write(save);
                file_writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
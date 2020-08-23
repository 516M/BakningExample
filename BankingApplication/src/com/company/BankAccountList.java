package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class BankAccountList {
    private Set<BankAccount> accounts;

    public BankAccountList(HashSet<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public boolean addBankAccount(BankAccount account) {
        this.accounts.add(account);
        return true;
    }

    public boolean removeBankAccount(BankAccount account) {
        this.accounts.remove(account);
        return true;
    }

    public boolean setBankAccountList(Set<BankAccount> accounts) {
        this.accounts = accounts;
        return true;
    }

    public Set<BankAccount> getBankAccountList() {
        return this.accounts;
    }

    @Override
    public String toString() {
        String result = "";
        Iterator<BankAccount> iterator = this.accounts.iterator();
        while(iterator.hasNext()) {
            result += iterator.next().toString() + "\n";
        }
        return result;
    }

    public static BankAccountList read(Scanner given_input) {
        BankAccountList ac = new BankAccountList(new HashSet<BankAccount>());
        while(given_input.hasNext()) {
            ac.accounts.add(BankAccount.read(given_input));
        }
        return ac;
    }

    // TODO: Create read from file and write to file methods (uses BankAccount's methods)
}

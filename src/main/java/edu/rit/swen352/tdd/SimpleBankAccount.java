package edu.rit.swen352.tdd;

public class SimpleBankAccount {

    private double balance;

    public SimpleBankAccount() {
        this.balance = 0;
    }

    public SimpleBankAccount(double initialBalance) {
       this.balance = initialBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        assert false: "NYI";
    }
}

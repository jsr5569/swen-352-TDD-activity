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

    public void deposit(double amount){
        if(amount < 0 || Double.isNaN(amount))
        {
            throw new IllegalArgumentException("Invalid amount");
        }
        else if(Double.isInfinite(amount + balance))
        {
            throw new IllegalArgumentException("Invalid amount");
        }
        this.balance += amount;
    }
}

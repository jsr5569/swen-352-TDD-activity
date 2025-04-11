package edu.rit.swen352.tdd;

import static java.lang.Math.round;

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
        balance = roundToTwoDecimals(balance + amount);
    }

    public double withdraw(double amount){
        balance = roundToTwoDecimals(this.balance - amount);
        return this.balance;
    }

    private static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}

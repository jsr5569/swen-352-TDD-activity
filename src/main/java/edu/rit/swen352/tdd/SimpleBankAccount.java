package edu.rit.swen352.tdd;

public class SimpleBankAccount {

    private static double balance;

    public SimpleBankAccount() {
        balance = 0;
    }

    public SimpleBankAccount(double initialBalance) {
       balance = initialBalance;
    }
    public double getBalance() {
        assert false: "NYI";
        return -1.0;
    }
}

package edu.rit.swen352.tdd;

/**
 * SimpleBankAccount represents a basic checking account
 *
 * <p>
 * SimpleBankAccount has these features:
 * <ul>
 *   <li>constructor: with or without initial balance</li>
 *   <li>deposit: Put an amount into the bank account,
 *   if an invalid amount then a {@link IllegalArgumentException} is thrown</li>
 *   <li>withdraw: Remove an amount from the bank account,
 *   if an invalid amount then a {@link IllegalArgumentException} is thrown</li>
 *   <li>getBalance: returns the current bank account balance
 * </ul>
 */
public class SimpleBankAccount {

    private double balance;

    /**
     * Create an empty simple bank account
     */
    public SimpleBankAccount() {
        this.balance = 0;
    }

    /**
     * Creates a simple bank account with an initial balance
     * @param initialBalance the initial balance
     */
    public SimpleBankAccount(double initialBalance) {
       this.balance = initialBalance;
    }

    /**
     * Returns the current balance of the bank account
     * @return the current balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Deposits an amount into the bank account
     * Throws and IllegalArgumentException if an invalid amount
     * @param amount the amount to deposit
     */
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

    /**
     * Withdraws an amount from the bank account
     * Throws and IllegalArgumentException if an invalid amount
     * @param amount the amount to withdraw
     */
    public double withdraw(double amount){
        if(amount < 0 || Double.isNaN(amount) || (balance - amount) < 0)
        {
            throw new IllegalArgumentException("Invalid amount");
        }
        balance = roundToTwoDecimals(this.balance - amount);
        return this.balance;
    }

    /**
     * Private utility method for ensuring amount stays at 2 decimal places
     * @param value the amount to round
     * @return the amount rounded to two decimal places
     */
    private static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}

package edu.rit.swen352.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBankAccountTest {

    @Test
    @DisplayName("Create Empty SimpleBankAccount")
    void createEmptyBankAccount() {
        SimpleBankAccount bankAccount = new SimpleBankAccount();
        assertAll("Constructor Assertions",
                () -> assertNotNull(bankAccount),
                () -> assertEquals(SimpleBankAccount.class.getSimpleName(), bankAccount.getClass().getSimpleName()));
    }

    @Test
    @DisplayName("Create SimpleBankAccount With Initial Amount")
    void createBankAccountWithAmount() {
        SimpleBankAccount bankAccount = new SimpleBankAccount(100.99);
        assertAll("Constructor Assertions",
                () -> assertNotNull(bankAccount),
                () -> assertEquals(SimpleBankAccount.class.getSimpleName(), bankAccount.getClass().getSimpleName()));
    }

    @Test
    @DisplayName("Get Account Balance")
    void getAccountBalance() {
        SimpleBankAccount bankAccount1 = new SimpleBankAccount();
        SimpleBankAccount bankAccount2 = new SimpleBankAccount(100.99);
        assertAll("Get Balance Assertions",
                () -> assertEquals(100.99, bankAccount2.getBalance()),
                () -> assertEquals(0, bankAccount1.getBalance()));
    }

    @Test
    @DisplayName("Deposit An Amount Into The Account")
    void depositAmount() {
        SimpleBankAccount bankAccount1 = new SimpleBankAccount();
        bankAccount1.deposit(100);
        SimpleBankAccount bankAccount2 = new SimpleBankAccount(100.99);
        bankAccount2.deposit(100.01);
        assertAll("Deposit Assertions",
                () -> assertEquals(201, bankAccount2.getBalance()),
                () -> assertEquals(100.00, bankAccount1.getBalance()));
    }

    @Test
    @DisplayName("Deposit An Invalid Amount Into The Account")
    void depositInvalidAmount() {
        SimpleBankAccount bankAccount = new SimpleBankAccount(Double.MAX_VALUE);
        assertAll("Deposit Assertions",
                () -> assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-1.5)),
                () -> assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(Double.NaN)),
                () -> assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(Double.MAX_VALUE)));
    }

    @Test
    @DisplayName("Withdraw An Amount From The Account")
    void withdrawAmount() {
        SimpleBankAccount bankAccount = new SimpleBankAccount(100.99);
        int remaining1 = bankAccount.withdraw(100);
        int remaining2 = bankAccount.withdraw(bankAccount.getBalance());
        assertAll("Withdraw Assertions",
                () -> assertEquals(0.99, remaining1),
                () -> assertEquals(0, remaining2));

    }
}

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
}

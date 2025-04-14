package edu.rit.swen352.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShoeAccountTest {

    @Test
    public void TestShoeConstructor() {
        ShoeAccount account = new ShoeAccount();
        assertNotNull(account);
    }
}

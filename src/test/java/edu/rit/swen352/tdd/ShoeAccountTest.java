package edu.rit.swen352.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShoeAccountTest {

    @Test
    public void TestShoeAccountConstructor() {
        ShoeAccount account = new ShoeAccount();
        assertNotNull(account);
    }

    @Test
    public void TestShoeConstructor() {
        Shoe shoe = new Shoe();
        assertNotNull(shoe);
    }
}

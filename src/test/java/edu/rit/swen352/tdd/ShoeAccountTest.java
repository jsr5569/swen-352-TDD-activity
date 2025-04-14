package edu.rit.swen352.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoeAccountTest {

    @Test
    public void TestShoeAccountConstructor() {
        ShoeAccount account = new ShoeAccount();
        assertNotNull(account);
    }

    @Test
    public void TestShoeConstructor() {
        Shoe shoe = new Shoe(9.5, 109.99, "Very Good");
        assertNotNull(shoe);
        assertEquals(9.5, shoe.size);
        assertEquals(109.99, shoe.price);
        assertEquals("Very Good", shoe.condition);
    }

    @Test
    public void TestAddShoeToAccount() {
        ShoeAccount account = new ShoeAccount();
        Shoe shoe = new Shoe(9.5, 109.99, "Very Good");
        account.addShoe(shoe);
        assertTrue(!account.shoes.isEmpty());
    }

    @Test
    public void TestRemoveShoeFromAccount() {
        ShoeAccount account = new ShoeAccount();
        Shoe shoe = new Shoe(9.5, 109.99, "Very Good");
        account.addShoe(shoe);
        account.removeShoe(shoe);
        assertEquals(0, account.shoes.size());
    }
}

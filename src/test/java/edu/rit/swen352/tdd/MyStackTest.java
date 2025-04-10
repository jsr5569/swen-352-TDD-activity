package edu.rit.swen352.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link MyStack} component.
 */
class MyStackTest {
    @Test
    public void TestConstructorWithoutCap() {
        MyStack stack = new MyStack<>();
        assertNotNull(stack);
    }
}

package edu.rit.swen352.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link MyStack} component.
 */
class MyStackTest {
    @Test
    public void TestConstructor() {
        MyStack stack = new MyStack<>();
        assertNotNull(stack);
    }

    @Test
    public void TestConstructorDefaultCapacity() {
        MyStack stack = new MyStack<>();
        assertEquals(16, stack.capacity);
    }

    @Test
    public void TestConstructorSpecificCapacity() {
        MyStack stack = new MyStack<>(10);
        assertEquals(10, stack.capacity);
    }
}

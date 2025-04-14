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
        int capacity = stack.array.length;
        assertEquals(16, capacity);
    }

    @Test
    public void TestConstructorSpecificCapacity() {
        MyStack stack = new MyStack<>(10);
        int capacity = stack.array.length;
        assertEquals(10, capacity);
    }

    @Test
    public void TestPush() {
        MyStack<Integer> stack = new MyStack<>();
        int value = 5;
        stack.push(value);
        assertTrue(stack.array.length > 0);
    }
}

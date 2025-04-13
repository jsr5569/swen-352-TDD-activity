package edu.rit.swen352.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link MyOptional} component.
 */
class MyOptionalTest {

    @Test
    @DisplayName("Create an empty optional")
    public void testEmpty(){
        MyOptional<?> op = MyOptional.empty();
        assertNotNull(op);
    }

    @Test
    @DisplayName("Create a non-empty optional")
    public void testNonEmpty(){
        MyOptional<Boolean> booleanOp = MyOptional.of(true);

        assertNotNull(booleanOp);
        assertEquals(MyOptional.class.getSimpleName(), booleanOp.getClass().getSimpleName());
        assertThrows(NullPointerException.class, () -> {
            MyOptional.of(null);
        });
    }

    @Test
    @DisplayName("Create an optional with a non-null as the element")
    public void testNullableNotNull(){
        MyOptional<Boolean> booleanOp = MyOptional.ofNullable(true);

        assertNotNull(booleanOp);
        assertEquals(MyOptional.class.getSimpleName(), booleanOp.getClass().getSimpleName());
    }

    @Test
    @DisplayName("Create a optional with null as the element")
    public void testNullableNull(){
        assertDoesNotThrow(() -> {
            MyOptional.ofNullable(null);
        });
        MyOptional<?> emptyOp = MyOptional.ofNullable(null);
        assertNotNull(emptyOp);
        assertEquals(MyOptional.class.getSimpleName(), emptyOp.getClass().getSimpleName());
    }

    @Test
    @DisplayName("Query if the optional is not empty")
    public void testIsPresent(){
        MyOptional<String> stringOp = MyOptional.of("Random element");
        MyOptional<?> emptyOp = MyOptional.empty();

        assertTrue(stringOp.isPresent());
        assertFalse(emptyOp.isPresent());

    }

    @Test
    @DisplayName("Get the element in the optional")
    public void testGetElementNotEmpty(){
        MyOptional<String> stringOp = MyOptional.of("Random element");

        assertEquals("Random element", stringOp.get());
    }

    @Test
    @DisplayName("Check that an exception is thrown when accessing the element of an empty optional")
    public void testGetElementEmpty(){
        MyOptional<?> emptyOp = MyOptional.empty();

        assertThrows(NoSuchElementException.class, emptyOp::get);
    }

    @Test
    @DisplayName("Transform a string by a function with map")
    public void testMapNonEmptyOptional() {
        MyOptional<String> op = MyOptional.of("hello");
        MyOptional<Integer> mappedOp = op.map(String::length);

        assertTrue(mappedOp.isPresent());
        assertEquals(5, mappedOp.get());
    }

    @Test
    @DisplayName("Check that map doesn't work on an empty option")
    public void testMapEmptyOptional() {
        MyOptional<String> op = MyOptional.empty();
        MyOptional<Integer> mappedOp = op.map(String::length);

        assertFalse(mappedOp.isPresent());
    }

    @Test
    @DisplayName("Check that the ifPresent method is called if there is a value in the optional")
    public void testIfPresentCalled() {
        MyOptional<String> op = MyOptional.of("Random element");
        final String[] consumerArray = new String[1];

        op.ifPresent(value -> consumerArray[0] = value.substring(1, 4));

        assertEquals("and", consumerArray[0]);
    }
}

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
}

package edu.rit.swen352.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}

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
        MyOptional<String> op = MyOptional.empty();
        assertNotNull(op);
    }
}

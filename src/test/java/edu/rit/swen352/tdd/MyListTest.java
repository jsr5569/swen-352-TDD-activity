package edu.rit.swen352.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link MyList} component.
 */
class MyListTest {

    @Test
    @DisplayName("No Initial Elements")
    void noInitialElements() {
        MyList<String> list = new MyList<String>();
        assertAll("group assertions",
                () ->  assertNotNull(list),
                () -> assertEquals(MyList.class.getSimpleName(), list.getClass().getSimpleName()));
    }

    @Test
    @DisplayName("Initial Elements")
    void initialElements() {
        MyList<String> list = new MyList<String>("string1", "string2");
        assertAll("group assertions",
                () ->  assertNotNull(list),
                () -> assertEquals(MyList.class.getSimpleName(), list.getClass().getSimpleName()));
    }
}

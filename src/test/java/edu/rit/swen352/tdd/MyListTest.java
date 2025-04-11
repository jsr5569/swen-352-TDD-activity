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
    @DisplayName("Create With No Initial Elements")
    void noInitialElements() {
        MyList<String> list = new MyList<String>();
        assertAll("constructor assertions",
                () ->  assertNotNull(list),
                () -> assertEquals(MyList.class.getSimpleName(), list.getClass().getSimpleName()));
    }

    @Test
    @DisplayName("Create With Initial Elements")
    void initialElements() {
        MyList<String> list = new MyList<String>("string1", "string2");
        assertAll("constructor assertions",
                () ->  assertNotNull(list),
                () -> assertEquals(MyList.class.getSimpleName(), list.getClass().getSimpleName()));
    }

    @Test
    @DisplayName("Get List Size")
    void getListSize()
    {
        MyList<Integer> list1 = new MyList<>();
        MyList<String> list2 = new MyList<>("string1", "string2", "string3");
        assertAll("Size Assertions",
                () -> assertEquals(0,list1.size()),
                () -> assertEquals(3,list2.size())
        );
    }
}

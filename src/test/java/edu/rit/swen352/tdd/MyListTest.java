package edu.rit.swen352.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.UpperCase;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

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

    @Test
    @DisplayName("Add New Element")
    void addElement()
    {
        MyList<Double> list1 = new MyList<>();
        MyList<String> list2 = new MyList<>("string1", "string2", "string3");
        assertAll("Add New Element Assertions",
                () -> assertEquals(1, list1.add(1.1).size()),
                () -> assertEquals(4, list2.add("newString").size()));
    }

    @Test
    @DisplayName("Add Duplicate Element")
    void addDuplicateElement()
    {
        MyList<String> list = new MyList<>("string1", "string2", "string3");
        assertAll("Add Duplicate Element Assertions",
                () -> assertEquals(3, list.add("string2").size()));
    }

    @Test
    @DisplayName("Remove Element")
    void removeElement()
    {
        MyList<String> list = new MyList<>("string1", "string2", "string3");
        assertAll("Remove Element Assertions",
                () -> assertEquals(2, list.remove("string2").size()));
    }

    @Test
    @DisplayName("Remove Nonexistent Element")
    void removeNonexistentElement()
    {
        MyList<String> list = new MyList<>("string1", "string2", "string3");
        assertAll("Remove Element Assertions",
                () -> assertThrows(NoSuchElementException.class, () -> list.remove("string5")));
    }

    @Test
    @DisplayName("Get Element")
    void getElement()
    {
        MyList<String> list = new MyList<>("string1", "string2", "string3");
        assertAll("Get Element Assertions",
                () -> assertEquals("string3",list.get(2)));
    }

    @Test
    @DisplayName("Get Element With Nonexistent Index")
    void getElementWithNonexistentIndex()
    {
        MyList<String> list = new MyList<>("string1", "string2", "string3");
        assertAll("Get Element Assertions",
                () -> assertThrows(NoSuchElementException.class,() -> list.get(5)),
                () -> assertThrows(NoSuchElementException.class,() -> list.get(-1)));
    }

    @Test
    @DisplayName("isEmpty")
    void isEmptyMyList()
    {
        MyList<Integer> list1 = new MyList<>();
        MyList<String> list2 = new MyList<>("string1", "string2", "string3");
        assertAll("Get Element Assertions",
                () -> assertTrue(list1.isEmpty()),
                () -> assertFalse(list2.isEmpty())
        );
    }

    @Test
    @DisplayName("ForEach")
    void forEach()
    {
        MyList<String> list = new MyList<>("apple", "banana", "pear");
        ArrayList<String> newList = new ArrayList<>();
        Consumer<String> add = string -> newList.add(string.toUpperCase());
        list.forEach(add);
        assertAll("ForEach Assertions",
                () -> assertEquals(list.size(), newList.size()),
                () -> assertEquals("PEAR",newList.get(2)));
    }

}

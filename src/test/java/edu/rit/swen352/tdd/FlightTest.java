package edu.rit.swen352.tdd;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightTest {

    @Test
    @DisplayName("Create an flight")
    public void testCreateFlight(){
        Flight f = new Flight("BA134", "Rochester", "Orlando", 5);
        assertNotNull(f);
        assertEquals(Flight.class.getSimpleName(), f.getClass().getSimpleName());
    }
}

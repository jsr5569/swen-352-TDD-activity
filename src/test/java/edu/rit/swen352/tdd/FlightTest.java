package edu.rit.swen352.tdd;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightTest {

    @Test
    @DisplayName("Create a flight")
    public void testCreateFlight(){
        Flight f = new Flight("BA134", "Rochester", "Orlando", 5);
        assertNotNull(f);
        assertEquals(Flight.class.getSimpleName(), f.getClass().getSimpleName());
    }

    @Test
    @DisplayName("Check that a NullPointerException is thrown when null parameters are supplied")
    public void testCreateFlightNullParams(){
        assertThrows(NullPointerException.class, () -> {
            Flight f = new Flight(null, null, null, 0);
        });
    }
}

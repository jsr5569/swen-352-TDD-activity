package edu.rit.swen352.tdd;

import java.util.HashMap;

/**
 * Flight represents a simple flight which passengers can book
 *
 * <p>
 *     Flight has the following features:
 *     <ul>
 *         <li>Constructor: with flight number, origin location, and destination location Strings and a total seat number integer; throws {@link java.lang.NullPointerException} if any params are null</li>
 *         <li>isSeatAvailable: Queries whether a seat is available for a passenger</li>
 *         <li>bookSeat: Adds a passenger's name and takes a seat to the flight if a seat is available; throws {@link java.lang.NullPointerException} if name is null</li>
 *         <li>cancelBooking: Removes a passenger's name from the flight and frees up a seat; throws a {@link java.util.NoSuchElementException} if there is no matching passenger name or the passenger name is null</li>
 *         <li>getAvailableSeats: Returns the number of available seats on the Flight</li>
 *         <li>getFlightNumber: Return the flight number</li>
 *         <li>FR: Constructor should also create an empty HashMap<String, Integer> for passenger names and an integer for the number of available seats initially set to the total number of seats</li>
 *     </ul>
 * </p>
 */
public class Flight {
    private String flight_number;
    private String origin;
    private String destination;
    private int total_seats;
    private int available_seats;
    private HashMap<String, Integer> passenger_names;

    public Flight(String flight_num, String flight_origin, String flight_destination, int num_total_seats){
        if(flight_num == null || flight_origin == null || flight_destination == null){
            throw new NullPointerException("Flight details cannot be null and/or flight must have seats");
        }

        this.flight_number = flight_num;
        this.origin = flight_origin;
        this.destination = flight_destination;
        this.total_seats = num_total_seats;
        this.available_seats = num_total_seats;
        this.passenger_names = new HashMap<>();
    }

    public boolean isSeatAvailable(){
        return this.available_seats > 0;
    }
}

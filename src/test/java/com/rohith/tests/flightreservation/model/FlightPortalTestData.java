package com.rohith.tests.flightreservation.model;

public record FlightPortalTestData(String firstName,
                                   String lastName,
                                   String email,
                                   String password,
                                   String street,
                                   String city,
                                   String zip,
                                   String passengersCount,
                                   String expectedPrice) {
}

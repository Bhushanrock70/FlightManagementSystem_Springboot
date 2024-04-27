package org.flightmanagementsystem.service;

import java.math.BigInteger;
import java.util.List;

import org.flightmanagementsystem.model.Flight;



public interface FlightService {

	 public Flight addFlight(Flight flight);
	 public List<Flight> viewFlight();
	 public Flight viewFlightByNumber(BigInteger flightNumber);
	 public Flight modifyFlight(Flight flight, BigInteger flightNumber);
	 public void deleteFlight(BigInteger flightNumber);
	
}

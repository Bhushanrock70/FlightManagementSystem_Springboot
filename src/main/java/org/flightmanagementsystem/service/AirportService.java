package org.flightmanagementsystem.service;

import java.util.List;

import org.flightmanagementsystem.model.Airport;


public interface AirportService {
	
	 public  Airport addAirport(Airport airport);
	 public List<Airport> viewAllAirport();
	 public Airport viewAirportByCode(long airportCode);
	 public Airport updateAirport(Airport airpot, long airportCode);
	 public void deleteAirport(long airportCode);
	
	 
}
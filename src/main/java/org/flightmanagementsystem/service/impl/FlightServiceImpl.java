package org.flightmanagementsystem.service.impl;

import java.math.BigInteger;
import java.util.List;


import org.flightmanagementsystem.dao.FlightDao;
import org.flightmanagementsystem.exceptions.ScheduledFlightNotFoundException;
import org.flightmanagementsystem.model.Flight;

import org.flightmanagementsystem.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {
    
    @Autowired
    private FlightDao flightDao;

	public FlightServiceImpl(FlightDao flightDao) {
		super();
		this.flightDao = flightDao;
	}

	@Override
	public Flight addFlight(Flight flight) {
		return flightDao.save(flight);
	}

	@Override
	public List<Flight> viewFlight() {
		return (List<Flight>) flightDao.findAll();
	}

	@Override
	public Flight viewFlightByNumber(BigInteger flightNumber) {
		 return flightDao.findById(flightNumber).orElseThrow( ()->
	        new ScheduledFlightNotFoundException("flight", "flightNumber", flightNumber));
	}

	@Override
	public Flight modifyFlight(Flight flight, BigInteger flightNumber) {
		Flight existingFlight= flightDao.findById(flightNumber).orElseThrow( ()->
        new ScheduledFlightNotFoundException("flight","flightNumber",flightNumber));
		
		//if the id found then we need to set the new values to update
	    existingFlight.setCarrierName(flight.getCarrierName());
	    existingFlight.setFlightModel(flight.getFlightModel());
	    existingFlight.setSeatCapacity(flight.getSeatCapacity());
		//save the exiting the order
	    flightDao.save(existingFlight);
		return existingFlight;
	}

	@Override
	public void deleteFlight(BigInteger flightNumber) {
		flightDao.findById(flightNumber).orElseThrow( ()->
        new ScheduledFlightNotFoundException("flight","flightNumber",flightNumber));
		flightDao.deleteById(flightNumber);
		
	}
    
	
    
}
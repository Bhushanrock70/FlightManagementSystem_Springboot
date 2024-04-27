package org.flightmanagementsystem.service.impl;

import java.util.List;

import org.flightmanagementsystem.dao.AirportDao;
import org.flightmanagementsystem.exceptions.ScheduledFlightNotFoundException;
import org.flightmanagementsystem.model.Airport;
import org.flightmanagementsystem.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {
    
    @Autowired
    private AirportDao airportDao;
    
	public AirportServiceImpl(AirportDao airportDao) {
		super();
		this.airportDao = airportDao;
	}

	@Override
    public Airport addAirport(Airport airport) {
		return airportDao.save(airport);
	}

	@Override
	public List<Airport> viewAllAirport() {
		return (List<Airport>) airportDao.findAll();
	}

	@Override
	public Airport viewAirportByCode(long airportCode) {
		 return airportDao.findById(airportCode).orElseThrow( ()->
	        new ScheduledFlightNotFoundException("airport", "Id", airportCode));
	}
   
	 @Override
	 public Airport updateAirport(Airport airport, long airportCode) {
	        //We need to check whether order with the given id is exsits in the DB or not
		    Airport existingAirport= airportDao.findById(airportCode).orElseThrow( ()->
	                  new ScheduledFlightNotFoundException("airport","Id",airportCode));
	        
	        //if the id found then we need to set the new values to update
		    existingAirport.setAirportName(airport.getAirportName());
		    existingAirport.setAirportLocation(airport.getAirportLocation());
	        //save the exiting the order
	    	airportDao.save(existingAirport);
	        return existingAirport;
	    }

	  @Override
	  public void deleteAirport(long airportCode)
	    {
	        //we need to check whether order record exists in the DB or not
		  airportDao.findById(airportCode).orElseThrow( ()->
	        new ScheduledFlightNotFoundException("airport","Id",airportCode));
		  airportDao.deleteById(airportCode);
	        
	    }	

}
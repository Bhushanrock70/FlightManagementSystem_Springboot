package org.flightmanagementsystem.controller;

import java.math.BigInteger;
import java.util.List;

import org.flightmanagementsystem.model.Flight;
import org.flightmanagementsystem.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/flight")
public class FlightController {
    
    private FlightService flightService;
    
    // constructor
    public FlightController(FlightService flightService) {
		super();
		this.flightService = flightService;
	}

	@PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        return new ResponseEntity<Flight>(flightService.addFlight(flight),HttpStatus.CREATED);
    }

	@GetMapping("")
	public List<Flight> viewFlight() {
		return flightService.viewFlight();
	}
    
	@GetMapping("{flightNumber}")
    public ResponseEntity<Flight> viewFlightByNumber(@PathVariable("flightNumber") BigInteger flightNumber){
		  
	     return new ResponseEntity<Flight>(flightService.viewFlightByNumber(flightNumber), HttpStatus.OK);    
	    }
	
    @PutMapping("{flightNumber}")
    public ResponseEntity<Flight> modifyFlight(@PathVariable("flightNumber")BigInteger flightNumber,
            @RequestBody Flight flight)
    {
        return new ResponseEntity<Flight>(flightService.modifyFlight(flight, flightNumber),HttpStatus.OK);
    }

    @DeleteMapping("{flightNumber}")
    public ResponseEntity<String> deleteFlight(@PathVariable("flightNumber")BigInteger flightNumber)
    {
        //delete
    	flightService.deleteFlight(flightNumber);
        return new ResponseEntity<String>("order deleted Successfully!",HttpStatus.OK);
    }


}

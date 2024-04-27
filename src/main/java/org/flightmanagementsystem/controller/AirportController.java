package org.flightmanagementsystem.controller;

import java.util.List;

import org.flightmanagementsystem.model.Airport;
import org.flightmanagementsystem.service.AirportService;
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
@RequestMapping("/airport")
public class AirportController {
    
    private AirportService airportService;



    public AirportController(AirportService airportService) {
        super();
        this.airportService = airportService;
    }
    
    @PostMapping
    public ResponseEntity<Airport> addAirport(@RequestBody Airport airport){
        return new ResponseEntity<Airport>(airportService.addAirport(airport),HttpStatus.CREATED);
    }

	@GetMapping("")
	public List<Airport> viewAllAirport() {
		return airportService.viewAllAirport();
	}
    
	@GetMapping("{airportCode}")
    public ResponseEntity<Airport> getOrderById(@PathVariable("airportCode") long airportCode){
		  
	     return new ResponseEntity<Airport>(airportService.viewAirportByCode(airportCode), HttpStatus.OK);    
	    }
	
    @PutMapping("{airportCode}")
    public ResponseEntity<Airport> updateAirport(@PathVariable("airportCode")long airportCode,
            @RequestBody Airport airport)
    {
        return new ResponseEntity<Airport>(airportService.updateAirport(airport, airportCode),HttpStatus.OK);
    }

    @DeleteMapping("{airportCode}")
    public ResponseEntity<String> deleteAirport(@PathVariable("airportCode")long airportCode)
    {
        //delete
    	airportService.deleteAirport(airportCode);
        return new ResponseEntity<String>("order deleted Successfully!",HttpStatus.OK);
    }


}

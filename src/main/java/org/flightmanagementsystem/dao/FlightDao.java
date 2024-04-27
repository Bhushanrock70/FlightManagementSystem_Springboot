package org.flightmanagementsystem.dao;


import java.math.BigInteger;

import org.flightmanagementsystem.model.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDao extends CrudRepository<Flight, BigInteger> {

	

}
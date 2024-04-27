package org.flightmanagementsystem.dao;

import org.flightmanagementsystem.model.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportDao extends CrudRepository<Airport, Long> {

	

}

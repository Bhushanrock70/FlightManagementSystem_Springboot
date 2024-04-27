package org.flightmanagementsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airport {


	@Id
    private long airportCode;
    @Column(name="airportName")
    private String airportName;
    @Column(name="airportLocation")
    private String airportLocation;
    
	public Airport(long airportCode, String airportName, String airportLocation) {
		super();
		this.airportCode = airportCode;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}

	public Airport() {
		super();
	}

	public long getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(long airportCode) {
		this.airportCode = airportCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportLocation() {
		return airportLocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}

	@Override
	public String toString() {
		return "Airport [airportCode=" + airportCode + ", airportName=" + airportName + ", airportLocation="
				+ airportLocation + "]";
	}
}

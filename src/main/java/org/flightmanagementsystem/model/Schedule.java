package org.flightmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long airCode;
	private String sourceAirport;
	private String destinationAirport;
	private String arrivalTime;
	private String departureTime;
	
	//parameterized constructor
	public Schedule(long airCode, String sourceAirport, String destinationAirport, String arrivalTime,
			String departureTime) {
		super();
		this.airCode = airCode;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	//default constructor
	public Schedule() {
		super();
	}

	//getter setter
	public long getAirportCode() {
		return airCode;
	}

	public void setAirportCode(long airportCode) {
		this.airCode = airportCode;
	}

	public String getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "Schedule [airCode=" + airCode + ", sourceAirport=" + sourceAirport + ", destinationAirport="
				+ destinationAirport + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + "]";
	}
	

}

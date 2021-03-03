package com.stackroute.flightapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Flight {

	@Id
	private String flightid;
	private String flightname;
	private String destination;
	private String arrival;
	
	public Flight() {
		
	}

	public String getFlightid() {
		return flightid;
	}

	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}

	public String getFlightname() {
		return flightname;
	}

	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	
	
	
}

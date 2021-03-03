package com.stackroute.flightapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.flightapp.model.Flight;
import com.stackroute.flightapp.model.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightRepository;

	public List<Flight> getAllFlights() {
		return (List<Flight>) flightRepository.findAll();
	}

	public Flight getFlightById(String flightid) {
		return flightRepository.findById(flightid).get();
	}
	
	

	public boolean addFlight(Flight flight) {
		Flight newFlight = flightRepository.save(flight);
		if(newFlight.getFlightid().equals(flight.getFlightid()))
				return true;
		else
				return false;
	}

	public List<Flight> getFlightsByArrival(String arrival) {
		
		return flightRepository.findByArrival(arrival);
	}

	public List<Flight> getFlightsByArrivalAndFlightName(String arrival, String flightname) {
		return flightRepository.findByArrivalAndFlightname(arrival, flightname);
	}

	public List<Flight> getFlightsByDestination(String flightname) {
		return flightRepository.findByMunichFlightname(flightname);
	}

	
	
	
}

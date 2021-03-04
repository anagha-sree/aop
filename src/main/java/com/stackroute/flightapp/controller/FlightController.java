package com.stackroute.flightapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.flightapp.model.Flight;
import com.stackroute.flightapp.service.FlightService;

@RestController
@RequestMapping("api/v1/flight")
public class FlightController {

	
	@Autowired
	private FlightService flightService;
	
	@GetMapping
	public ResponseEntity<List<Flight>> getAllFlights() throws Exception{
		List<Flight> flightlist = flightService.getAllFlights();
		if(flightlist.size() > 0) {
			throw new Exception();
		}
		return new ResponseEntity<>(flightlist,HttpStatus.OK);
	}
	
	@GetMapping("/{flightid}")
	public ResponseEntity<Flight> getFlightinfo(@PathVariable String flightid){
		Flight flight = flightService.getFlightById(flightid);
		return new ResponseEntity<Flight>(flight,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addFlight(@RequestBody Flight flight){
		boolean status = flightService.addFlight(flight);
		if(status)
			return new ResponseEntity<Flight>(flight,HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Flight not added",HttpStatus.CONFLICT);
	}
	
	@GetMapping("/arrival/{arrival}")
	public ResponseEntity<List<Flight>> getFlightByArrival(@PathVariable String arrival){
		List<Flight> flight = flightService.getFlightsByArrival(arrival);
		return new ResponseEntity<List<Flight>>(flight,HttpStatus.OK);
	}
	
	
	@GetMapping("/allflights/{arrival}/{flightname}")
	public ResponseEntity<List<Flight>> getFlightByArrival(@PathVariable String arrival,@PathVariable String flightname){
		List<Flight> flight = flightService.getFlightsByArrivalAndFlightName(arrival,flightname);
		return new ResponseEntity<List<Flight>>(flight,HttpStatus.OK);
	}
	
	@GetMapping("/destination/{flightname}")
	public ResponseEntity<List<Flight>> getFlightByDestination(@PathVariable String flightname){
		List<Flight> flight = flightService.getFlightsByDestination(flightname);
		return new ResponseEntity<List<Flight>>(flight,HttpStatus.OK);
	}
	
	
}

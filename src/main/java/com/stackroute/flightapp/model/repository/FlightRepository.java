package com.stackroute.flightapp.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.stackroute.flightapp.model.Flight;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String>{
	List<Flight> findByArrival(String arrival);
	List<Flight> findByArrivalAndFlightname(String arrival,String flightname);
	
	@Query("{'destination':'Munich','flightname':?0}")
	List<Flight> findByMunichFlightname(String flightname);
}


//@Query(" select fly from flight fly where fly.flightname =:flightname and fly.destintion= :destination")
//List<Flight> myquery(String flightname,String destination);
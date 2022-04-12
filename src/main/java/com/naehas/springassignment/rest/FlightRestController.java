package com.naehas.springassignment.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naehas.springassignment.entities.Flight;
import com.naehas.springassignment.service.FlightService;

@RestController
@RequestMapping("/api")
public class FlightRestController {
	
	private FlightService flightService;
	
	@Autowired
	public FlightRestController(FlightService theFlightService) {
		flightService = theFlightService;
	}
	
	// finding all flights in Flights Table
	
	@GetMapping("/flights")
	public List<Flight> findAll(){
		return flightService.findAll();
	}
	
	// finding flight details by flightId
	@GetMapping("/flights/{flightId}")
	public Flight getFlight(@PathVariable int flightId) {
		
		Flight theFlight = flightService.findById(flightId);
		
		if (theFlight == null) {
			throw new RuntimeException("Flight id not found- " + flightId);
		}
		
		return theFlight;
	}
	
	// adding new flight details
	@PostMapping("/flights")
	public Flight addflight(@RequestBody Flight theFlight) {
		
		theFlight.setId(0);
		
		flightService.save(theFlight);
		
		return theFlight;
		
	}
	
	// updation on an existing flight details
	@PutMapping("/flights")
	public Flight updateFlight(@RequestBody Flight theFlight) {
	
		flightService.save(theFlight);
		
		return theFlight;
	}
	
	// deleteing an existing Flight by id
	@DeleteMapping("/flights/{flightId")
	public String deleteFlight(@PathVariable int flightId) {
		
		Flight flight = flightService.findById(flightId); 
		
		if(flight == null) {
			throw new RuntimeException("Flight id not found - " + flightId);
		}
		
		flightService.deleteById(flightId);
		
		return "Deleted the flight id- " + flightId;
	}
	
	
}

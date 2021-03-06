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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naehas.springassignment.entities.Flight;
import com.naehas.springassignment.entities.FlightFare;
import com.naehas.springassignment.service.FlightFareService;

@RestController
@RequestMapping("/api")
public class FlightFareRestController {

	private FlightFareService flightFareService;
	
	@Autowired
	public FlightFareRestController(FlightFareService theFlightFareService) {
		flightFareService = theFlightFareService;
	}
	
	// finding all flight Fares in Flight Fare Table
	
	@GetMapping("/flight_fare")
	public List<FlightFare> findAll(){
		return flightFareService.findAll();
	}
	
	// finding flight Fare details by flightId
	@GetMapping("/flight_fare/{flightFareId}")
	public FlightFare getFlightFare(@PathVariable int flightFareId) {
		
		FlightFare theFlightFare = flightFareService.findById(flightFareId);
		
		if (theFlightFare == null) {
			throw new RuntimeException("Flight Fare id not found- " + flightFareId);
		}
		
		return theFlightFare;
	}
	
	// adding new flight Fare details
	@PostMapping("/flight_fare")
	public FlightFare addflightFare(@RequestBody FlightFare theFlightFare) {
		
		theFlightFare.setId(0);
		
		flightFareService.save(theFlightFare);
		
		return theFlightFare;
		
	}
	
	// updation on an existing flight Fare details
	@PutMapping("/flight_fare")
	public FlightFare updateFlightFare(@RequestBody FlightFare theFlightFare) {
	
		flightFareService.save(theFlightFare);
		
		return theFlightFare;
	}
	
	// deleteing an existing Flight Fare by id
	@DeleteMapping("/flight_fare/{flightFareId}")
	public String deleteFlightFare(@PathVariable int flightFareId) {
		
		FlightFare theFlightFare = flightFareService.findById(flightFareId); 
		
		if(theFlightFare == null) {
			throw new RuntimeException("Flight Fare id not found - " + flightFareId);
		}
		
		flightFareService.deleteById(flightFareId);
		
		return "Deleted the Flight Fare id- " + flightFareId;
	}
	
	@GetMapping("/flight_fare/sortByFare")
	public List<FlightFare> sortAsc(){
		return flightFareService.findAllByOrderByFareAsc();
	}
	
	@GetMapping("/flight_fare/sortByFareDesc")
	public List<FlightFare> sortDesc(){
		return flightFareService.findAllByOrderByFareDesc();
	}
	
	@GetMapping("/flight_fare/uptoFare")
	public List<FlightFare> uptoFare(@RequestParam int fare){
		return flightFareService.uptoFare(fare);
	}
	
	@GetMapping("/flight_fare/isRefundable")
	public List<FlightFare> flightisRefundable(@RequestParam boolean refund){
		return flightFareService.flightisRefundable(refund);
	}
}

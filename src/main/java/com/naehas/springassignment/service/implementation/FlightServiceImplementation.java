package com.naehas.springassignment.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naehas.springassignment.dao.FlightRepository;
import com.naehas.springassignment.entities.Flight;
import com.naehas.springassignment.service.FlightService;

@Service
public class FlightServiceImplementation implements FlightService {

	private FlightRepository flightRepository;
	
	@Autowired
	public FlightServiceImplementation(FlightRepository theFlightRepository) {
		flightRepository = theFlightRepository;
	}
	
	@Override
	public List<Flight> findAll() {
		return flightRepository.findAll();
	}

	@Override
	public Flight findById(int flightId) {
		Optional<Flight> flight = flightRepository.findById(flightId);
		
		Flight theFlight = null;
		
		if(flight.isPresent()) {
			theFlight = flight.get();
		}
		
		else {
			throw new RuntimeException("Did not found the flight details by id - " + flightId);
		}
		
		return theFlight;
	}

	@Override
	public void save(Flight flight) {
		flightRepository.save(flight);
	}

	@Override
	public void deleteById(int flightId) {
		flightRepository.deleteById(flightId);
	}

	public List<Flight> findAirline(String airline){
		return flightRepository.findAirline(airline);
	}
}

package com.naehas.springassignment.service;

import java.util.List;

import com.naehas.springassignment.entities.Flight;

public interface FlightService {

	public List<Flight> findAll();
	
	public Flight findById(int flightId);
	
	public void save(Flight flight);
	
	public void deleteById(int flightId);
	
	public List<Flight> findAirline(String airline);
}

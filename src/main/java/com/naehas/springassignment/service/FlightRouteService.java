package com.naehas.springassignment.service;

import java.util.List;

import com.naehas.springassignment.entities.FlightRoute;

public interface FlightRouteService {
	
	public List<FlightRoute> findAll();
	
	public FlightRoute findById(int flightRouteId);
	
	public void save(FlightRoute flightRoute);
	
	public void deleteById(int flightRouteId);

	public List<FlightRoute> searchFlightRoutes(String keyword);
	
}

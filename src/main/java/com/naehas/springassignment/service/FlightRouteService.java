package com.naehas.springassignment.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.naehas.springassignment.entities.FlightRoute;

public interface FlightRouteService {
	
	public List<FlightRoute> findAll();
	
	public FlightRoute findById(int flightRouteId);
	
	public void save(FlightRoute flightRoute);
	
	public void deleteById(int flightRouteId);

	public List<FlightRoute> searchFlightRoutes(String departureLocation,String arrivalLocation,String departOn);
	
	public List<FlightRoute> findAllByOrderBydepartOnAsc();
	
	public List<FlightRoute> findAllByOrderBydepartOnDesc();
	
}

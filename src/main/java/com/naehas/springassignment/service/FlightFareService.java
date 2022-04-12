package com.naehas.springassignment.service;

import java.util.List;

import com.naehas.springassignment.entities.FlightFare;

public interface FlightFareService {
	
	public List<FlightFare> findAll();
	
	public FlightFare findById(int flightFareId);
	
	public void save(FlightFare flightFare);
	
	public void deleteById(int flightFareId);
}

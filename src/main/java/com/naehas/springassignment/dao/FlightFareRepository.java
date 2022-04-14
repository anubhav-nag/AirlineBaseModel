package com.naehas.springassignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naehas.springassignment.entities.FlightFare;

public interface FlightFareRepository extends JpaRepository<FlightFare, Integer> {

	@Query("SELECT flightFare FROM FlightFare flightFare ORDER BY flightFare.fare ")
	public List<FlightFare> findAllByOrderByFareAsc();
	
	@Query("SELECT flightFare FROM FlightFare flightFare ORDER BY flightFare.fare DESC")
	public List<FlightFare> findAllByOrderByFareDesc();
}

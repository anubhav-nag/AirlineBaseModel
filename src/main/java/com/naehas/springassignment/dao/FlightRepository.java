package com.naehas.springassignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.naehas.springassignment.entities.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Query("SELECT flight FROM Flight flight WHERE flight.airline LIKE %?1%")
	public List<Flight> findAirline(String airline);
}

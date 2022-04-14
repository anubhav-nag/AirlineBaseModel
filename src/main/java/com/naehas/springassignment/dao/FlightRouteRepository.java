package com.naehas.springassignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naehas.springassignment.entities.FlightFare;
import com.naehas.springassignment.entities.FlightRoute;

public interface FlightRouteRepository extends JpaRepository<FlightRoute, Integer> {
	
	@Query("SELECT flightRoute FROM FlightRoute flightRoute WHERE flightRoute.departureLocation LIKE %?1%"
            + " OR flightRoute.arrivalLocation LIKE %?1%"
            + " OR flightRoute.departOn LIKE %?1%" )
	public List<FlightRoute> search(String keyword);

	@Query("SELECT flightRoute FROM FlightRoute flightRoute ORDER BY flightRoute.departOn ")
	public List<FlightRoute> findAllByOrderBydepartOnAsc();
	
	@Query("SELECT flightRoute FROM FlightRoute flightRoute ORDER BY flightRoute.departOn DESC")
	public List<FlightRoute> findAllByOrderBydepartOnDesc();
}

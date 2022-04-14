package com.naehas.springassignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.naehas.springassignment.entities.FlightRoute;

public interface FlightRouteRepository extends JpaRepository<FlightRoute, Integer> {
	
	@Query("SELECT flightRoute FROM FlightRoute flightRoute WHERE flightRoute.departureLocation = :departureLocation"
            + " AND flightRoute.arrivalLocation = :arrivalLocation"
            + " AND flightRoute.departOn = :departOn" )
	public List<FlightRoute> search(@Param("departureLocation") String departureLocation,
									@Param("arrivalLocation") String arrivalLocation,
									@Param("departOn") String departOn);

	@Query("SELECT flightRoute FROM FlightRoute flightRoute ORDER BY flightRoute.departOn ")
	public List<FlightRoute> findAllByOrderBydepartOnAsc();
	
	@Query("SELECT flightRoute FROM FlightRoute flightRoute ORDER BY flightRoute.departOn DESC")
	public List<FlightRoute> findAllByOrderBydepartOnDesc();
}

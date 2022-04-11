package com.naehas.springassignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naehas.springassignment.entities.FlightRoute;

public interface FlightRouteRepository extends JpaRepository<FlightRoute, Integer> {

}

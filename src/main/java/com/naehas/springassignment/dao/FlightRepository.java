package com.naehas.springassignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naehas.springassignment.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

}

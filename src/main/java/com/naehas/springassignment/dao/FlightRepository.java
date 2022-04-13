package com.naehas.springassignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naehas.springassignment.entities.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

}

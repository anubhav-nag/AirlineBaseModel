package com.naehas.springassignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naehas.springassignment.entities.FlightFare;

public interface FlightFareRepository extends JpaRepository<FlightFare, Integer> {

}

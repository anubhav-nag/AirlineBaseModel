package com.naehas.springassignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naehas.springassignment.entities.Flight;

public interface FlightsRepository extends JpaRepository<Flight, Integer> {

}

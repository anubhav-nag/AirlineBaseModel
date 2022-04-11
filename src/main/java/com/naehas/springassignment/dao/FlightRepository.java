package com.naehas.springassignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.naehas.springassignment.entities.Flight;

//@RepositoryRestResource(path="flightdetail")
public interface FlightRepository extends JpaRepository<Flight, Integer> {

}

package com.naehas.springassignment.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naehas.springassignment.dao.FlightFareRepository;
import com.naehas.springassignment.entities.FlightFare;
import com.naehas.springassignment.service.FlightFareService;

@Service
public class FlightFareServiceImplementation implements FlightFareService {

	private FlightFareRepository flightFareRepository;
	
	@Autowired
	public FlightFareServiceImplementation(FlightFareRepository theFlightFareRepository) {
		flightFareRepository = theFlightFareRepository; 
	}
	
	@Override
	public List<FlightFare> findAll() {
		return flightFareRepository.findAll();
	}

	@Override
	public FlightFare findById(int flightFareId) {
		Optional<FlightFare> flightFare = flightFareRepository.findById(flightFareId);
		
		FlightFare fare = null;
		
		if(flightFare.isPresent()) {
			fare = flightFare.get();
		}
		else {
			throw new RuntimeException("Did not got the flight's fare details for the id- " + flightFareId);
		}
		
		return fare;
	}

	@Override
	public void save(FlightFare flightFare) {
		flightFareRepository.save(flightFare);
	}

	@Override
	public void deleteById(int flightFareId) {
		flightFareRepository.deleteById(flightFareId);
	}

	@Override
	public List<FlightFare> findAllByOrderByFareAsc() {
		return flightFareRepository.findAllByOrderByFareAsc();
	}

	@Override
	public List<FlightFare> findAllByOrderByFareDesc() {
		return flightFareRepository.findAllByOrderByFareDesc();
	}

}

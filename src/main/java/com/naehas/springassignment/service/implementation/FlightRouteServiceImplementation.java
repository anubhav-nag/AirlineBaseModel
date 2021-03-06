package com.naehas.springassignment.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.naehas.springassignment.dao.FlightRouteRepository;
import com.naehas.springassignment.entities.FlightRoute;
import com.naehas.springassignment.service.FlightRouteService;

@Service
public class FlightRouteServiceImplementation implements FlightRouteService {

	private FlightRouteRepository flightRouteRepository;
	
	@Autowired
	public FlightRouteServiceImplementation(FlightRouteRepository theFlightRouteRepository) {
		flightRouteRepository = theFlightRouteRepository;
	}
	
	@Override
	public List<FlightRoute> findAll() {
		return flightRouteRepository.findAll();
	}

	@Override
	public FlightRoute findById(int flightRouteId) {
		Optional<FlightRoute> flightRoute = flightRouteRepository.findById(flightRouteId);
		
		FlightRoute theFlightRoute = null;
		
		if(flightRoute.isPresent()) {
			theFlightRoute = flightRoute.get();
		}
		else {
			throw new RuntimeException("Did not found the flight route details of id - " + flightRouteId);
		}
		
		return theFlightRoute;
	}

	@Override
	public void save(FlightRoute flightRoute) {
		flightRouteRepository.save(flightRoute);
	}

	@Override
	public void deleteById(int flightRouteId) {
		flightRouteRepository.deleteById(flightRouteId);
	}

	@Override
	public List<FlightRoute> searchFlightRoutes(String departureLocation, String arrivalLocation,String departOn) {
		if(departureLocation == null) {
			throw new RuntimeException("departureLocation missing");
		}
		else if(arrivalLocation == null) {
			throw new RuntimeException("arrivalLocation missing");
		}
		else if(departOn == null) {
			throw new RuntimeException("Departing time is missing");
		}
		return flightRouteRepository.search(departureLocation, arrivalLocation, departOn);
	}

	@Override
	public List<FlightRoute> findAllByOrderBydepartOnAsc() {
		return flightRouteRepository.findAllByOrderBydepartOnAsc();
	}

	@Override
	public List<FlightRoute> findAllByOrderBydepartOnDesc() {
		
		return flightRouteRepository.findAllByOrderBydepartOnDesc();
	}

}

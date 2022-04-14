package com.naehas.springassignment.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naehas.springassignment.entities.FlightRoute;
import com.naehas.springassignment.service.FlightRouteService;

@RestController
@RequestMapping("/api")
public class FlightRouteRestController {

private FlightRouteService flightRouteService;
	
	@Autowired
	public FlightRouteRestController(FlightRouteService theFlightRouteService) {
		flightRouteService = theFlightRouteService;
	}
	
	// finding all flight Routes in Flight Route Table
	
	@GetMapping("/flight_routes")
	public List<FlightRoute> findAll(){
		return flightRouteService.findAll();
	}
	
	// finding flight route details by flightId
	@GetMapping("/flight_routes/{flightRouteId}")
	public FlightRoute getFlightRoute(@PathVariable int flightRouteId) {
		
		FlightRoute theFlightRoute = flightRouteService.findById(flightRouteId);
		
		if (theFlightRoute == null) {
			throw new RuntimeException("Flight Route id not found- " + flightRouteId);
		}
		
		return theFlightRoute;
	}
	
	// adding new flight route details
	@PostMapping("/flight_routes")
	public FlightRoute addflightRoute(@RequestBody FlightRoute theFlightRoute) {
		
		theFlightRoute.setId(0);
		
		flightRouteService.save(theFlightRoute);
		
		return theFlightRoute;
		
	}
	
	// updation on an existing flight route details
	@PutMapping("/flight_routes")
	public FlightRoute updateFlightRoute(@RequestBody FlightRoute theFlightRoute) {
	
		flightRouteService.save(theFlightRoute);
		
		return theFlightRoute;
	}
	
	// deleteing an existing Flight Route by id
	@DeleteMapping("/flight_routes/{flightRouteId}")
	public String deleteFlightRoute(@PathVariable int flightRouteId) {
		
		FlightRoute theFlightRoute = flightRouteService.findById(flightRouteId); 
		
		if(theFlightRoute == null) {
			throw new RuntimeException("Flight Route id not found - " + flightRouteId);
		}
		
		flightRouteService.deleteById(flightRouteId);
		
		return "Deleted the Flight Route id- " + flightRouteId;
	}
	
	// search according to the params : departure location, arrival location, date of departure
	
//	@GetMapping("/flightRoutes/searchBar")
//    public List<FlightRoute> searchCustomers(@RequestParam("departureLocation") String departureLocation,
//    		@RequestParam("arrivalLocation") String arrivalLocation,
//    		@RequestParam("departOn") String departOn) {
//        
//		List<FlightRoute> theFlightRoutes = flightRouteService.searchFlightRoutes(departureLocation, arrivalLocation, departOn);
//               
//        return theFlightRoutes;        
//    }
	
	@GetMapping("/flight_routes/searchBar")
    public List<FlightRoute> searchCustomers(@RequestParam("keyword") String keyword) {
        
		List<FlightRoute> theFlightRoutes = flightRouteService.searchFlightRoutes(keyword);
               
        return theFlightRoutes;        
    }
	
}

package com.naehas.springassignment.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="flight_routes")
public class FlightRoute {

	// added all columns of flight_routes table
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="departure_location")
	private String departureLocation;
	
	@Column(name="arrival_location")
	private String arrivalLocation;
	
	@Column(name="departs_on")
	private String departOn;
	
	@Column(name="arrive_on")
	private String arriveOn;
	
//	@Column(name="flight_id")
//	private int flightId;
//	
//	@Column(name="fare_id")
//	private int fareId;

	@ManyToOne(fetch=FetchType.LAZY,cascade={CascadeType.MERGE,CascadeType.DETACH,
			CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinColumn(name="fare_id")
	private FlightFare flightFare;
	
	
    
    @OneToOne(fetch=FetchType.LAZY,cascade={CascadeType.MERGE,CascadeType.DETACH,
			CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinColumn(name="flight_id")
	private Flight flight;
	
	// default construcutor
	
	public FlightRoute() {
	}
	
	
	// constructor with fields

	public FlightRoute(String departureLocation, String arrivalLocation, String departOn, String arriveOn) {
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.departOn = departOn;
		this.arriveOn = arriveOn;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public String getDepartOn() {
		return departOn;
	}

	public void setDepartOn(String departOn) {
		this.departOn = departOn;
	}

	public String getArriveOn() {
		return arriveOn;
	}

	public void setArriveOn(String arriveOn) {
		this.arriveOn = arriveOn;
	}

//	public int getFlightId() {
//		return flightId;
//	}
//
//	public void setFlightId(int flightId) {
//		this.flightId = flightId;
//	}
//
//	public int getFareId() {
//		return fareId;
//	}
//
//	public void setFareId(int fareId) {
//		this.fareId = fareId;
//	}

	@Override
	public String toString() {
		return "FlightRoute [id=" + id + ", departureLocation=" + departureLocation + ", arrivalLocation="
				+ arrivalLocation + ", departOn=" + departOn + ", arriveOn=" + arriveOn +  "]";
	}

	
}

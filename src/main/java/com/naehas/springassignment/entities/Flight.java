package com.naehas.springassignment.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="flights")
public class Flight {
	
	// added all columns of the flight table

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="airline")
	private String airline;
	
	@Column(name="flight_no")
	private String flightNo;
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL) 
	private FlightRoute flightRoute;
	
	// default constructor

	public Flight() {
	
	}
	
	// constrcutor with fields

	public Flight(String airline, String flightNo) {
		this.airline = airline;
		this.flightNo = flightNo;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", flightNo=" + flightNo + "]";
	}
	
}

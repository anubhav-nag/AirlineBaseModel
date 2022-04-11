package com.naehas.springassignment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight_fare")
public class FlightFare {
	
	// added columns of flight_fare table 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="class")
	private String class_type;
	
	@Column(name="fare")
	private int fare;
	
	@Column(name="is_refundable")
	private boolean isRefundable;

	// default constructor
	
	public FlightFare() {
	
	}
	
	// constructor with fields
	
	public FlightFare(String class_type, int fare, boolean isRefundable) {
		this.class_type = class_type;
		this.fare = fare;
		this.isRefundable = isRefundable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClass_type() {
		return class_type;
	}

	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public boolean isRefundable() {
		return isRefundable;
	}

	public void setRefundable(boolean isRefundable) {
		this.isRefundable = isRefundable;
	}

	@Override
	public String toString() {
		return "FlightFare [id=" + id + ", class_type=" + class_type + ", fare=" + fare + ", isRefundable="
				+ isRefundable + "]";
	}
	
	
}

package com.kiselproject.choosehotels.beans;

import java.util.Date;

public class HotelSearchBean {

	private String hotelName;	
	private Date arrival;
	private Date departure;
	private Integer numberOfRooms;
	private Integer numberOfPersons;

	public HotelSearchBean() {
		super();
	}

	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	public Integer getNumberOfRooms() {
		return numberOfRooms;
	}
	public void setNumberOfRooms(Integer numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	public Integer getNumberOfPersons() {
		return numberOfPersons;
	}
	public void setNumberOfPersons(Integer numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}
}

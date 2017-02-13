package com.kiselproject.choosehotels.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Room")
public class Room  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;

	@Column(name="NUMBER_OF_PERSONS")
	private Integer number_of_persons;

	@Column(name="PRICE")
	private Double price;

	@Column(name="DESCRIPTION")

	private String description;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "FK_HOTEL_ID")
	private Hotel hotel;

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	@OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "room")
	@JsonIgnore
	private Set<Orders> orders;


	@ManyToMany(cascade={CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinTable(name = "Room_Dates",
    joinColumns = { @JoinColumn(name="FK_ROOM_ID") },
    inverseJoinColumns = { @JoinColumn(name="FK_DATES_ID") })
	@JsonIgnore
	private Set<Dates> dates;


	public Set<Dates> getDates() {
		return dates;
	}

	public void setDates(Set<Dates> dates) {
		this.dates = dates;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNumber_of_persons() {
		return number_of_persons;
	}

	public void setNumber_of_persons(Integer number_of_persons) {
		this.number_of_persons = number_of_persons;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Room() {

	}

}

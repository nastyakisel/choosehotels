package com.kiselproject.choosehotels.domain;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Dates")
public class Dates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;

	@Column(name="ROOM_DATE")
	private Date room_date;

	@ManyToMany(cascade={CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "dates")
	@JsonIgnore
	private Set<Room> rooms;

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public Dates() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRoom_date() {
		return room_date;
	}

	public void setRoom_date(Date room_date) {
		this.room_date = room_date;
	}

}

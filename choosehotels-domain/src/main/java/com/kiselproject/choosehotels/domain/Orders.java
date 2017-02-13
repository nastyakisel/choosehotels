package com.kiselproject.choosehotels.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Orders {

	public Orders() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private	Integer id;

	@Column(name="CONTACTNAME")
	private String contactName;

	@Column(name="SURNAME")
	private String surname;

	@Column(name="EMAIL")
	private String email;

	@Column(name="ADDRESS")
	private String address;

	@Column(name="CCNUMBER")
	private Integer ccNumber;

	@Column(name="DATE_OF_ARRIVAL")
	private Date dateOfArrival;

	@Column(name="DATE_OF_DISPATURE")
	private Date dateOfDispature;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "FK_ORDER_ROOM_ID")
	private Room room;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(Integer ccNumber) {
		this.ccNumber = ccNumber;
	}

	public Date getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(Date dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	public Date getDateOfDispature() {
		return dateOfDispature;
	}

	public void setDateOfDispature(Date dateOfDispature) {
		this.dateOfDispature = dateOfDispature;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}

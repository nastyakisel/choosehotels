package com.kiselproject.choosehotels.beans;

import java.util.Date;

public class ReservationBean {

	private String contactName;	
	private String surname;
	private String address;
	private String email;
	private Integer ccNumber;
	private Date arr;
	private Date depat;
	private Integer roomId;
	
	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public ReservationBean() {
		super();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(Integer ccNumber) {
		this.ccNumber = ccNumber;
	}

	public Date getArr() {
		return arr;
	}

	public void setArr(Date arr) {
		this.arr = arr;
	}

	public Date getDepat() {
		return depat;
	}

	public void setDepat(Date depat) {
		this.depat = depat;
	}

	
}

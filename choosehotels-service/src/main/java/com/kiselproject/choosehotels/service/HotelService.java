package com.kiselproject.choosehotels.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.kiselproject.choosehotels.domain.City;
import com.kiselproject.choosehotels.domain.Dates;
import com.kiselproject.choosehotels.domain.Hotel;
import com.kiselproject.choosehotels.domain.Orders;
import com.kiselproject.choosehotels.domain.Room;
import com.kiselproject.choosehotels.domain.Visitor;

public interface HotelService {

	Hotel getHotelByHotelName(String hotelName);
	List<Room> getRoomsByHotel(Hotel hotel, Integer number);
	List<City> getAllCities();
	Integer storeRoom(Room room, String nameOfHotel, Date date);
	void storeHotel(Hotel hotel, String nameOfHotel);
	Hotel getHotelById(Integer id);
	List<Room> getRoomsByHotelAndDate2(Hotel hotel, Integer number, Date dates_form_form, Date date_depature);
	Set<Room> getRoomsByHotelAndDate3(Hotel hotel, Integer number, Date dates_form_form, Date date_depature);
	void storeDates(Date date, Integer roomId);
	List<Hotel> getHotelsByCity(Integer number);
	List<Room> getRoomsByHotel(Integer number);
	void storeVisitor(Visitor visitor);
	Room getRoomById(Integer id);
	void storeOrder(Orders order);
	void sendEmail(String email);
	City getCityByName(String cityName);
	List<Orders> getAllOrdrs();
}

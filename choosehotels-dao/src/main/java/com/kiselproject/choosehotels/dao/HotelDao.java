package com.kiselproject.choosehotels.dao;


import java.util.Date;
import java.util.List;
import java.util.Set;

import com.kiselproject.choosehotels.domain.City;
import com.kiselproject.choosehotels.domain.Dates;
import com.kiselproject.choosehotels.domain.Hotel;
import com.kiselproject.choosehotels.domain.Orders;
import com.kiselproject.choosehotels.domain.Room;
import com.kiselproject.choosehotels.domain.Visitor;

 public interface HotelDao {


	Hotel loadHotelByName(String hotelName);
	List<Room> loadRoomsByHotel(Hotel hotel, Integer number);
	List<City> loadAllCities();
	City loadCityByName(String citylName);
	Integer saveRoom(Room room, String nameOfHotel, Date date);
	void saveHotel(Hotel hotel, String nameOfCity);
	Hotel loadHotelById(Integer id);
	List<Room> loadRoomsByHotelAndDate2(Hotel hotel, Integer number, Date dates_form_form, Date date_depature);
	Set<Room> loadRoomsByHotelAndDate3(Hotel hotel, Integer number, Date dates_form_form, Date date_depature);
	Room loadRoomById(Integer id);
	void saveDates(Date date, Integer roomId);
	List<Hotel> loadHotelsByCity(Integer cityId);
	List<Room> loadRoomsByHotel(Integer number);
	void saveVisitor(Visitor visitor);
	void saveOrder(Orders order);
	List<Orders> loadAllOrders();

}


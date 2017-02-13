package com.kiselproject.choosehotels.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kiselproject.choosehotels.dao.HotelDao;
import com.kiselproject.choosehotels.domain.City;
import com.kiselproject.choosehotels.domain.Dates;
import com.kiselproject.choosehotels.domain.Hotel;
import com.kiselproject.choosehotels.domain.Orders;
import com.kiselproject.choosehotels.domain.Room;
import com.kiselproject.choosehotels.domain.Visitor;
import com.kiselproject.choosehotels.service.HotelService;


@Component
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelDao hotelDao;

	@Override
	public Hotel getHotelByHotelName(String hotelName)
	{
		return hotelDao.loadHotelByName(hotelName);

	}

	@Override
	public List<Room> getRoomsByHotel(Hotel hotel, Integer number)
	{

		return hotelDao.loadRoomsByHotel(hotel,number);
	}


	@Override
	public List<Room> getRoomsByHotelAndDate2(Hotel hotel, Integer number, Date dates_form_form, Date date_depature)
	{

		return hotelDao.loadRoomsByHotelAndDate2(hotel, number, dates_form_form, date_depature);
	}

	@Override
	public Set<Room> getRoomsByHotelAndDate3(Hotel hotel, Integer number, Date dates_form_form, Date date_depature)
	{

		return hotelDao.loadRoomsByHotelAndDate3(hotel, number, dates_form_form, date_depature);
	}


	public List<City> getAllCities()
	{
		return hotelDao.loadAllCities();

	}
	@Override
	public Integer storeRoom(Room room, String nameOfHotel, Date date)
	{
		return hotelDao.saveRoom(room, nameOfHotel, date);
	}
	@Override
	public void storeHotel(Hotel hotel, String nameOfHotel)
	{
		hotelDao.saveHotel(hotel, nameOfHotel);

	}

	public Hotel getHotelById(Integer id)
	{
		return hotelDao.loadHotelById(id);

	}

	public void storeDates(Date date, Integer roomId)
	{
		hotelDao.saveDates(date, roomId);

	}
	public List<Hotel> getHotelsByCity(Integer number)
	{

		return hotelDao.loadHotelsByCity(number);
	}
	public List<Room> getRoomsByHotel(Integer number)
	{

		return hotelDao.loadRoomsByHotel(number);
	}

	public void storeVisitor(Visitor visitor)
	{
		hotelDao.saveVisitor(visitor);

	}
	public Room getRoomById(Integer id)
	{
		return hotelDao.loadRoomById(id);

	}
	public void storeOrder(Orders order)
	{

		hotelDao.saveOrder(order);
	}

	public City getCityByName(String cityName)
	{
		return hotelDao.loadCityByName(cityName);

	}
	public void sendEmail(String email)
	{

	}
	public List<Orders> getAllOrdrs()
	{

		return hotelDao.loadAllOrders();
	}
}

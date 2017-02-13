package com.kiselproject.choosehotels.hibernate;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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


@Component
public class HotelDaoImpl implements HotelDao {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	@Transactional
	public Hotel loadHotelByName(String hotelName) throws UnsupportedOperationException
	{
		Session session = sessionFactory.getCurrentSession();

		Query query = session.getNamedQuery("selectHotelByName");
		query.setString("name", hotelName);

		List<Hotel> hotels = query.list();

		if (hotels.size() >= 1) {
			return hotels.get(0);
		}

		return null;
	}
	@Override
	@Transactional
	public City loadCityByName(String cityName) throws UnsupportedOperationException
	{
		Session session = sessionFactory.getCurrentSession();

		Query query = session.getNamedQuery("selectCityByName");

		query.setString("name", cityName);

		List<City> cities = query.list();

		if (cities.size() >= 1) {
			return cities.get(0);
		}

		return null;
	}

	@Override
	@Transactional
	public Hotel loadHotelById(Integer id) throws UnsupportedOperationException
	{
		Session session = sessionFactory.getCurrentSession();

		Hotel hotel = (Hotel) session.load(Hotel.class, id);

		if (hotel != null) {
			return hotel;
		}

		return null;
	}

	@Override
	@Transactional
	public List<Room> loadRoomsByHotel(Hotel hotel, Integer number) throws UnsupportedOperationException
	{
		Session session = sessionFactory.getCurrentSession();

		String name_of_hotel = hotel.getHotelName();
		Query query = session.createQuery("from Room r where r.hotel.hotelName = '"+name_of_hotel+"' and r.number_of_persons = "+number+"");

		List<Room> rooms = query.list();

		if (rooms.size() >= 1) {
			return rooms;
		}

		return null;

	}

	@Override
	@Transactional
	public List<Room> loadRoomsByHotelAndDate2(Hotel hotel, Integer number, Date dates_form_form, Date date_depature) throws UnsupportedOperationException
	{
		Session session = sessionFactory.getCurrentSession();

		String name_of_hotel = hotel.getHotelName();


		Query query = session.createQuery("from Room r join r.dates rd where r.number_of_persons = "+number+" and r.hotel.hotelName = '"+name_of_hotel+"' and rd.room_date >= :dates_form_form and rd.room_date <= :date_depature");


		query.setParameter("dates_form_form", dates_form_form);
		query.setParameter("date_depature", date_depature);
		List<Object[]> obj = query.list();

		List<Room> rooms = new ArrayList<Room>();
		for (int i = 0; i < obj.size(); i++)
		{

			Object[] j = obj.get(i);
			Room r = (Room) j[0];

			rooms.add(r);
		}

		for (int g = 0; g < rooms.size(); g++)
		{
			for (int k = 1; k < rooms.size(); k++)
			{
			if (rooms.get(g).getId() == rooms.get(k).getId())
			{
				rooms.remove(k);
			}
			}
		}

			if (rooms.size() >= 1) {
				return rooms;
			}

		return null;

	}

	@Override
	@Transactional
	public Set<Room> loadRoomsByHotelAndDate3(Hotel hotel, Integer number, Date dates_form_form, Date date_depature) throws UnsupportedOperationException
	{
		Session session = sessionFactory.getCurrentSession();

		String name_of_hotel = hotel.getHotelName();


		Query query = session.createQuery("from Room r join r.dates rd where r.number_of_persons = "+number+" and r.hotel.hotelName = '"+name_of_hotel+"' and rd.room_date >= :dates_form_form and rd.room_date <= :date_depature");


		query.setParameter("dates_form_form", dates_form_form);
		query.setParameter("date_depature", date_depature);
		List<Object[]> obj = query.list();

		List<Room> rooms = new ArrayList<Room>();
		for (int i = 0; i < obj.size(); i++)
		{

			Object[] j = obj.get(i);
			Room r = (Room) j[0];

			rooms.add(r);
		}

		Set<Room> roomSet = new HashSet<Room>();
		roomSet.addAll(rooms);

			if (roomSet.size() >= 1) {
				return roomSet;
			}

		return null;

	}

	@Override
	@Transactional
	public List<City> loadAllCities() throws UnsupportedOperationException
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from City c");
		List<City> cities = query.list();

		if (cities.size() >= 1) {
			return cities;
		}

		return null;
	}

	@Override
	@Transactional
	public Integer saveRoom(Room room, String nameOfHotel, Date date) throws UnsupportedOperationException
	{
		Session session = sessionFactory.getCurrentSession();

		Room r1 = new Room();

		r1.setNumber_of_persons(room.getNumber_of_persons());
		r1.setPrice(room.getPrice());
		r1.setDescription(room.getDescription());
		r1.setHotel(loadHotelByName(nameOfHotel));

		Dates d1 = new Dates();
		d1.setRoom_date(date);

		Set<Dates> dates = new HashSet();
		dates.add(d1);

		r1.setDates(dates);

		session.save(r1);
		session.save(d1);

		return r1.getId();
	}

	@Override
	@Transactional
	public void saveHotel(Hotel hotel, String nameOfCity) throws UnsupportedOperationException
	{
		Session session = sessionFactory.getCurrentSession();
		Hotel h = new Hotel();

		h.setHotelName(hotel.getHotelName());
		h.setHotelAddress(hotel.getHotelAddress());
		h.setCity(loadCityByName(nameOfCity));

		session.save(h);
	}

	@Override
	@Transactional
	public Room loadRoomById(Integer id) throws UnsupportedOperationException
	{
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Room r where id ="+id+"");
		List<Room> listResult = query.list();
		Room room = (Room) listResult.get(0);

		if (room != null) {
			return room;
		}

		return room;
	}

	@Override
	@Transactional
	public void saveDates(Date date, Integer roomId) throws UnsupportedOperationException
	{
		Session session = sessionFactory.getCurrentSession();
		Dates dates = new Dates();
		dates.setRoom_date(date);

		Room room = loadRoomById(roomId);
		Set<Dates> d = room.getDates();
		d.add(dates);

		room.setDates(d);

		Set<Room> rooms = new HashSet();


		rooms.add(room);

		dates.setRooms(rooms);

		session.save(dates);

	}


	@Override
	@Transactional
	public List<Hotel> loadHotelsByCity(Integer cityId) throws UnsupportedOperationException
	{
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Hotel h where h.city.id = "+cityId+"");

		List<Hotel> hotels = query.list();


		if (hotels.size() >= 1) {
			return hotels;
		}

		return null;

	}

	@Override
	@Transactional
	public List<Room> loadRoomsByHotel(Integer number) throws UnsupportedOperationException
	{
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Room r where r.hotel.id = "+number+"");

		List<Room> rooms = query.list();

		if (rooms.size() >= 1) {
			return rooms;
		}

		return null;

	}

	@Override
	@Transactional
	public void saveVisitor(Visitor visitor) throws UnsupportedOperationException {
		Session session = sessionFactory.getCurrentSession();

		session.save(visitor);


	}

	@Override
	@Transactional
	public void saveOrder(Orders order) throws UnsupportedOperationException {

		Session session = sessionFactory.getCurrentSession();

		session.save(order);


	}

	@Override
	@Transactional
	public List<Orders> loadAllOrders() throws UnsupportedOperationException
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Orders o");
		List<Orders> orders = query.list();

		if (orders.size() >= 1) {
			return orders;
		}

		return new ArrayList<Orders>();
	}


	public List<Orders> loaddfgdf() throws UnsupportedOperationException
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Orders o");
		List<Orders> orders = query.list();

		if (orders.size() >= 1) {
			return orders;
		}

		return new ArrayList<Orders>();
	}

}

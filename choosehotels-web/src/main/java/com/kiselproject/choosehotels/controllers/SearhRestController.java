package com.kiselproject.choosehotels.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiselproject.choosehotels.beans.HotelSearchBean;
import com.kiselproject.choosehotels.beans.ReservationBean;
import com.kiselproject.choosehotels.domain.City;
import com.kiselproject.choosehotels.domain.Hotel;
import com.kiselproject.choosehotels.domain.Orders;
import com.kiselproject.choosehotels.domain.Room;
import com.kiselproject.choosehotels.service.HotelService;


@RestController
public class SearhRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Autowired
	private HotelService hotelService;


	@ResponseBody
	@RequestMapping(value="/restsearchResults", method = RequestMethod.POST)
	public ResponseEntity<List<Room>> searchResults(@RequestBody HotelSearchBean searchBean) {

		Hotel h = new Hotel();
		h.setHotelName(searchBean.getHotelName());

		List<Room> rooms = hotelService.getRoomsByHotelAndDate2(h, searchBean.getNumberOfPersons(), searchBean.getArrival(), searchBean.getDeparture());

		return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value="/restsearchResults2", method = RequestMethod.POST)
	public ResponseEntity<Set<Room>> restsearchResults(@RequestBody HotelSearchBean searchBean) {

		Hotel h = new Hotel();
		h.setHotelName(searchBean.getHotelName());

		Set<Room> rooms = hotelService.getRoomsByHotelAndDate3(h, searchBean.getNumberOfPersons(), searchBean.getArrival(), searchBean.getDeparture());

		return new ResponseEntity<Set<Room>>(rooms, HttpStatus.OK);
	}


	@ResponseBody
	@RequestMapping(value="/getAllCities", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<City>> getAllCities() {


	List<City> cities = hotelService.getAllCities();
	return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value="/getAllHotels", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Hotel>> getHotels(@RequestParam Integer id) {


	List<Hotel> hotels = hotelService.getHotelsByCity(id);

	return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value="/getAllRooms", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Room>> getAllRooms(@RequestParam Integer id) {


	List<Room> rooms = hotelService.getRoomsByHotel(id);

	return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value="/reservation", method = RequestMethod.POST)// produces="application/json")
	public ResponseEntity<Void> reservation(@RequestBody ReservationBean reservationBean) {


		Orders order = new Orders();
		order.setAddress(reservationBean.getAddress());
		order.setCcNumber(reservationBean.getCcNumber());
		order.setContactName(reservationBean.getContactName());
		order.setSurname(reservationBean.getSurname());
		order.setEmail(reservationBean.getEmail());
		order.setDateOfArrival(reservationBean.getArr());
		order.setDateOfDispature(reservationBean.getDepat());

		Room room = hotelService.getRoomById(reservationBean.getRoomId());
		order.setRoom(room);

		hotelService.storeOrder(order);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

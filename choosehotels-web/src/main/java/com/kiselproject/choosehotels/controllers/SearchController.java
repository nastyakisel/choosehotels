package com.kiselproject.choosehotels.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kiselproject.choosehotels.domain.Dates;
import com.kiselproject.choosehotels.domain.Hotel;
import com.kiselproject.choosehotels.domain.Orders;
import com.kiselproject.choosehotels.domain.Room;
import com.kiselproject.choosehotels.service.HotelService;


@Controller
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private HotelService hotelService;


	@RequestMapping({"/searchResults.htm"})
	    public ModelAndView searchResults(Hotel hotel, HttpServletRequest request) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("hotel", hotel);

		return new ModelAndView("searchResults", model);
	    }

	@RequestMapping("/hibernateSearchResults.htm")
	public ModelAndView hibernateSearchResults(Hotel hotel, Room room) {


		List<Room> rooms = hotelService.getRoomsByHotel(hotel, room.getNumber_of_persons());

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("rooms", rooms);

		return new ModelAndView("searchResults", model);
	}

	@RequestMapping("/hibernateSearchResults2.htm")
	public ModelAndView hibernateSearchResults2(Hotel hotel, Room room, HttpServletRequest request) {

		/*Hotel hotel1 = hotelService.getHotelByHotelName(hotel.getHotelName());*/


		String arrival1 = request.getParameter("arrival");
		String departure1 = request.getParameter("departure");

			Date arrival = null;
			Date departure = null;
			try {
				arrival = new SimpleDateFormat("yyyy-MM-dd").parse(arrival1);
				departure = new SimpleDateFormat("yyyy-MM-dd").parse(departure1);
			} catch (ParseException e) {

				e.printStackTrace();
			}

		List<Room> rooms = hotelService.getRoomsByHotelAndDate2(hotel, room.getNumber_of_persons(), arrival, departure);


		Map<String, Object> model = new HashMap<String, Object>();

		model.put("rooms", rooms);
		model.put("arrival1", arrival1);
		model.put("departure1", departure1);


		return new ModelAndView("searchResults", model);
	}


	@RequestMapping("/saveDates.htm")
	public ModelAndView saveDates(HttpServletRequest request)
	{
		String dates = request.getParameter("room_date");
		String room_id = request.getParameter("room_id");
		Integer id = Integer.parseInt(room_id);
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dates);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		hotelService.storeDates(date, id);

		return new ModelAndView("administrator3");
	}

	@RequestMapping("/saveRooms.htm")
	public ModelAndView saveRooms(Room room, HttpServletRequest request)
	{

		String hotelName = request.getParameter("hotel_name");
		String arr = request.getParameter("arr");

		Date date = null;

		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(arr);

		} catch (ParseException e) {

			e.printStackTrace();
		}
		Integer id = hotelService.storeRoom(room, hotelName, date);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", id);
		return new ModelAndView("administrator3", model);
	}

	@RequestMapping("/saveHotels.htm")
	public ModelAndView saveHotels(Hotel hotel, HttpServletRequest request)
	{
		String citylName = request.getParameter("city_name");
		hotelService.storeHotel(hotel, citylName);

		return new ModelAndView("administrator");
	}
	@RequestMapping("/showOrders.htm")
	public ModelAndView showOrders()
	{
		List<Orders> orders =  hotelService.getAllOrdrs();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("orders", orders);
		return new ModelAndView("showOrder", model);
	}

}

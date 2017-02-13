package com.kiselproject.choosehotels.controllers;



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kiselproject.choosehotels.domain.City;
import com.kiselproject.choosehotels.domain.Hotel;
import com.kiselproject.choosehotels.domain.Room;
import com.kiselproject.choosehotels.domain.Visitor;
import com.kiselproject.choosehotels.service.HotelService;


@Controller
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private HotelService hotelService;


	@RequestMapping({"/welcome.htm", "/"})
    public ModelAndView showWelcomePage() {

		List<City> allcities = hotelService.getAllCities();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("allcities", allcities);

        return new ModelAndView("administrator", model);

    }

	@RequestMapping({"/browseCatalog.htm", "/"})
    public ModelAndView browseCatalogPage(HttpServletRequest request) {

		String stringId = request.getParameter("id");
		Integer city_Id = Integer.parseInt(stringId);

		List<Hotel> hotels = hotelService.getHotelsByCity(city_Id);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("hotels", hotels);

        return new ModelAndView("browseCatalog", model);

    }

	@RequestMapping({"/browseHotel.htm", "/"})
    public ModelAndView browseHotelPage(HttpServletRequest request) {

		String stringId = request.getParameter("id");
		Integer hotel_Id = Integer.parseInt(stringId);

		List<Room> rooms = hotelService.getRoomsByHotel(hotel_Id);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("rooms", rooms);

        return new ModelAndView("browseHotels", model);

    }
	@RequestMapping({"/loginPage.htm", "/"})
    public ModelAndView registerPage(HttpServletRequest request) {


        return new ModelAndView("loginPage");

    }

	@RequestMapping({"/saveLoginData.htm", "/"})
    public ModelAndView saveLoginData(Visitor visitor) {


		hotelService.storeVisitor(visitor);

        return new ModelAndView("browseHotels");

    }
	@RequestMapping({"/private/test.htm", "/"})
    public ModelAndView test() {


        return new ModelAndView("browseHotels");

    }
	@RequestMapping({"/private/adm.htm", "/"})
    public ModelAndView welcome() {


        return new ModelAndView("administrator");

    }
	@RequestMapping({"/reservationPage.htm", "/"})
    public ModelAndView reservation(HttpServletRequest request) {

		String stringId = request.getParameter("id");
		Integer room_Id = Integer.parseInt(stringId);
		String arrival2 = request.getParameter("ar");
		String departure2 = request.getParameter("dep");


		Room myroom = hotelService.getRoomById(room_Id);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("myroom", myroom);
		model.put("arrival2", arrival2);
		model.put("departure2", departure2);

        return new ModelAndView("reservation", model);

    }

}

package com.rezatrue.dhaka.web.application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rezatrue.dhaka.business.domain.RoomReservation;
import com.rezatrue.dhaka.business.service.ReservationService;

@Controller
@RequestMapping(value="/reservations")
public class ReservationController {
	
	private static final DateFormat DATE_FROMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private ReservationService reservationService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public String getReservations(@RequestParam(value="date", required = false) String dateString, Model model) {
		
		List<RoomReservation> roomReservationList = this.reservationService.getRoomReservationsForDate(dateString);
		model.addAttribute("roomReservations", roomReservationList);
		return "reservations";
	}
	

}

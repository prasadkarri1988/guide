package com.local.guide.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.local.guide.model.Booking;
import com.local.guide.service.BookingService;
import com.local.guide.validation.AgeValidator;

@RestController
public class BookingController {

	@Autowired
	private AgeValidator ageValidator;

	@Autowired
	private BookingService bookingService;

	@PutMapping(path = "/booking/save", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Booking> saveBooking(@Valid @RequestBody Booking booking) {
		ageValidator.validate(booking);
		Booking bookingreponse = bookingService.saveBooking(booking);
		ResponseEntity<Booking> responseEntity = null;
		if (bookingreponse != null) {
			responseEntity = new ResponseEntity<Booking>(bookingreponse, HttpStatus.CREATED);
		}
		return responseEntity;
	}

	@PostMapping(path = "/booking/update", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Booking> updateBooking(@Valid @RequestBody Booking booking) {
		ageValidator.validate(booking);
		Booking bookingreponse = bookingService.saveBooking(booking);
		ResponseEntity<Booking> responseEntity = null;
		if (bookingreponse != null) {
			responseEntity = new ResponseEntity<Booking>(bookingreponse, HttpStatus.CREATED);
		}
		return responseEntity;
	}

	@PostMapping(path = "/booking/cancle", produces = { "application/json" })
	public ResponseEntity<Boolean> cancleBooking(@RequestParam("bookingId") long bookingId) {
		Boolean cancleStatus = bookingService.cancleBooking(bookingId);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(cancleStatus, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(path = "/booking/get", produces = { "application/json" })
	public ResponseEntity<Booking> getBooking(@RequestParam long bookingId) {
		Booking booking = bookingService.getBooking(bookingId);
		ResponseEntity<Booking> responseEntity = new ResponseEntity<Booking>(booking, HttpStatus.OK);
		return responseEntity;
	}
	
	
	@PostMapping(path = "/booking/getBookingByDate")
	public ResponseEntity<List<Booking>> getBookingSpecificDay(@RequestParam("bookingDate")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date bookingDate) throws ParseException {
		List<Booking> booking = bookingService.getBookingSpecificDay(bookingDate);
		ResponseEntity<List<Booking>> responseEntity = new ResponseEntity<List<Booking>>(booking, HttpStatus.OK);
		return responseEntity;
	}


}

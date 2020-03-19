package com.local.guide.service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.guide.dao.BookingDao;
import com.local.guide.model.Booking;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingdao;

	public Booking saveBooking(Booking booking) {
		booking = bookingdao.save(booking);
		return booking;
	}

	public Booking updateBooking(Booking booking) {
		Optional<Booking> bookingInfo = bookingdao.findById(booking.getBookingID());
		if (bookingInfo.isPresent()) {
			booking = bookingdao.save(booking);
		}
		return booking;
	}

	public boolean cancleBooking(long bookingID) {
		Optional<Booking> bookingInfo = bookingdao.findById(bookingID);
		boolean status = false;
		if (bookingInfo.isPresent()) {
			Booking Canclebooking = bookingInfo.get();
			Canclebooking.setBookingStatus(false);
			Canclebooking = bookingdao.save(Canclebooking);
			status = true;
		}
		return status;
	}

	public Booking getBooking(long bookingID) {
		Optional<Booking> bookingInfo = bookingdao.findById(bookingID);
		Booking booking = null;
		if (bookingInfo.isPresent()) {
			booking = bookingInfo.get();
		}
		return booking;
	}

	public List<Booking> getBookingSpecificDay(Date bookingDate) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(bookingDate);
		cal.add(Calendar.DATE, 1); 
		Date bookingEndDate = cal.getTime();
		List<Booking> bookings = bookingdao.findAllByBookingDate(bookingDate, bookingEndDate);
		return bookings;

	}
}

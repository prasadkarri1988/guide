package com.local.guide.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.local.guide.model.Booking;
import com.local.guide.model.Hiker;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceTest {

	@Autowired
	private BookingService bookingService;

	private Booking booking;
	private List<Hiker> hikers;

	@Before
	public void init() {
		Hiker hiker = new Hiker(1, "prasad", "1988-08-08", "prasad.karri@gmail.com", "9866597538");
		hikers = new ArrayList<>();
		hikers.add(hiker);
		booking = new Booking(1, new Date(), 1, true, hikers);
	}

	@Test
	public void cancleBooking() {
		booking = bookingService.saveBooking(booking);
		Boolean status = bookingService.cancleBooking(1);
		Assert.assertTrue(status);
	}

	@Test
	public void asaveBooking() {
		booking = bookingService.saveBooking(booking);
		Assert.assertEquals(1, booking.getBookingID());
	}
	
	@Test
	public void updateBooking() {
		booking = bookingService.saveBooking(booking);
		booking = bookingService.updateBooking(booking);
		Assert.assertEquals(1, booking.getBookingID());
	}

	@Test
	public void getBooking() {
		Booking booking = bookingService.getBooking(1);
		Assert.assertEquals(1, booking.getBookingID());
	}

	@Test
	public void getBookingByDate() throws ParseException {
		List<Booking> booking = bookingService.getBookingSpecificDay(new Date());
		Assert.assertTrue(booking.size() >= 0);
	}

}
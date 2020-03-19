package com.local.guide.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.local.guide.model.Booking;
import com.local.guide.model.Hiker;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void saveBookingsInValidbookingDate() throws Exception {
		mockMvc.perform(put("/booking/save").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(new Booking(1, null, 1, true, null))))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors").value("Please provide a BookingDate")).andReturn();
	}

	@Test
	public void saveBookingsAgeNotWithInTrailsLimit() throws Exception {
		Hiker hiker = new Hiker(1, "prasad", "2019-08-08", "prasad.karri@gmail.com", "9866597538");
		List<Hiker> hikers = new ArrayList<>();
		hikers.add(hiker);
		mockMvc.perform(put("/booking/save").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(new Booking(1, new Date(), 1, true, hikers))))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("your age not allow with in selected trail")).andReturn();

	}

	@Test
	public void saveBookingsEmailIdIsNull() throws Exception {
		Hiker hiker = new Hiker(1, "prasad", "1988-08-08", "", "9866597538");
		List<Hiker> hikers = new ArrayList<>();
		hikers.add(hiker);
		mockMvc.perform(put("/booking/save").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(new Booking(1, new Date(), 1, true, hikers))))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors").value("Please provide a valid email ID")).andReturn();
	}

	@Test
	public void saveBookingsNameIsNull() throws Exception {
		Hiker hiker = new Hiker(1, "", "1988-08-08", "prasad.karri@gmail.com", "9866597538");
		List<Hiker> hikers = new ArrayList<>();
		hikers.add(hiker);
		mockMvc.perform(put("/booking/save").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(new Booking(1, new Date(), 1, true, hikers))))
				.andExpect(status().isBadRequest()).andExpect(jsonPath("$.errors").exists()).andReturn();
	}

	@Test
	public void getBookingForSpecificDay() throws Exception {
		mockMvc.perform(
				post("/booking/getBookingByDate?bookingDate=2020-02-29").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void getBookingById() throws Exception {
		mockMvc.perform(get("/booking/get?bookingId=1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void updateBooking() throws Exception {
		Hiker hiker = new Hiker(1, "prasad", "1988-08-08", "prasadkarri1988@gmail.com", "9866597538");
		List<Hiker> hikers = new ArrayList<>();
		hikers.add(hiker);
		mockMvc.perform(post("/booking/update").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(new Booking(1, new Date(), 1, true, hikers))))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.bookingID").exists()).andReturn();
	}

	@Test
	public void cancleBooking() throws Exception {
		mockMvc.perform(post("/booking/cancle?bookingId=1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void saveBooking() throws Exception {
		Hiker hiker = new Hiker(1, "prasad", "1988-08-08", "prasad.karri@gmail.com", "9866597538");
		List<Hiker> hikers = new ArrayList<>();
		hikers.add(hiker);
		mockMvc.perform(put("/booking/save").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(new Booking(1, new Date(), 1, true, hikers))))
				.andExpect(status().isCreated());
	}

}

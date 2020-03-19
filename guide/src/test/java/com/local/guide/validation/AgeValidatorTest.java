package com.local.guide.validation;

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
import com.local.guide.service.TrailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgeValidatorTest {

	@Autowired
	TrailService trailService;

	@Autowired
	private AgeValidator ageValidator;
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
	public void validateAgeForTails() {
		boolean status = ageValidator.validate(booking);
		Assert.assertTrue(status);
	}

}

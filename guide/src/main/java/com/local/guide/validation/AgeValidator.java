package com.local.guide.validation;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.local.guide.exception.AgeValidationException;
import com.local.guide.model.Booking;
import com.local.guide.model.Hiker;
import com.local.guide.model.Trail;
import com.local.guide.service.TrailService;

@Component
public class AgeValidator {

	@Autowired
	private TrailService trailService;
	private Map<Long, Trail> trailsmap = new HashMap<>();

	public AgeValidator() {
	}

	public boolean validate(Booking booking) {
		List<Hiker> hikers = booking.getHikers();
		long selectedTrailID = booking.getTrailid();

		for (Hiker hike : hikers) {
			int age = calculateAge(hike.getDob());
			Trail trail = trailsmap.get(selectedTrailID);
			if (!(trail.getMaxAge() >= age && trail.getMinAge() <= age)) {
				throw new AgeValidationException("your age not allow with in selected trail");
			}
		}
		return true;
	}

	@PostConstruct
	public void init() {
		List<Trail> trails = trailService.getAlltrails();
		for (Trail trail : trails) {
			trailsmap.put(trail.getId(), trail);
		}
	}

	public int calculateAge(String dob) {
		LocalDate birthDate = LocalDate.parse(dob);
		Date input = new Date();
		LocalDate currentDate = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return Period.between(birthDate, currentDate).getYears();
	}
}

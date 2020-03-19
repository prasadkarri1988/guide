package com.local.guide.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.local.guide.model.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Long> {

	@Query("FROM Booking  b WHERE b.bookingDate BETWEEN ?1 AND ?2")
	List<Booking> findAllByBookingDate(Date BookingTimeStart, Date bookingTimeEnd);

}

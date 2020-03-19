package com.local.guide.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingID;

	@NotNull(message = "Please provide a BookingDate")
	@Column
	private Date bookingDate;

	@NotNull(message = "Please provide a trailid")
	@Column
	private long trailid;

	@Column(columnDefinition = "boolean default true")
	private Boolean bookingStatus=true;

	@Valid
	@OneToMany(targetEntity = Hiker.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Hiker> hikers;


	public Booking() {
		super();
	}
	
    
	public Booking(long bookingID, @NotNull(message = "Please provide a BookingDate") Date bookingDate,
			@NotNull(message = "Please provide a trailid") long trailid, Boolean bookingStatus,
			@Valid List<Hiker> hikers) {
		super();
		this.bookingID = bookingID;
		this.bookingDate = bookingDate;
		this.trailid = trailid;
		this.bookingStatus = bookingStatus;
		this.hikers = hikers;
	}




	public long getBookingID() {
		return bookingID;
	}

	public void setBookingID(long bookingID) {
		this.bookingID = bookingID;
	}

	public long getTrailid() {
		return trailid;
	}

	public void setTrailid(long trailid) {
		this.trailid = trailid;
	}

	public List<Hiker> getHikers() {
		return hikers;
	}

	public void setHikers(List<Hiker> hikers) {
		this.hikers = hikers;
	}

	public Boolean getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(Boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
}

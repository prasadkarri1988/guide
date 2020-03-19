package com.local.guide.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Hiker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Please provide a name")
	@Size(min = 2, max = 30)
	private String name;

	@NotEmpty(message = "Please provide a date of birth")
	private String dob;

	@NotEmpty(message = "Please provide a valid email ID")
	private String emailID;

	private String phoneNumber;

	public Hiker() {

	}
	

	public Hiker(int id, @NotEmpty(message = "Please provide a name") @Size(min = 2, max = 30) String name,
			@NotEmpty(message = "Please provide a date of birth") String dob,
			@NotEmpty(message = "Please provide a valid email ID") String emailID, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.emailID = emailID;
		this.phoneNumber = phoneNumber;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}

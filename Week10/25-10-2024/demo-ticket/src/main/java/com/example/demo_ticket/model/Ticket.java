package com.example.demo_ticket.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;

import java.util.Date;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Username cant be blank")
	@Column
	private String username;

	@NotNull
	@NotBlank
	@Size(min = 3, max = 100)
	@Column
	private String fromplace;
	
	@NotNull
	@Column
	private String toplace;
	
	@NotNull
	@Email
	@Column
	private String email;
	
	@DecimalMin("99.9") 
	@DecimalMax("10000")
	@Column
	private float price;
	
	//@Past
	@Future(message = "date should be in future")
	private Date traveldate;
	
	// 012345
	
	@Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$")
	private String pincode;

	public Ticket() {}
	
	public Ticket(int id, @NotNull(message = "Username cant be blank") String username, @NotNull String fromplace,
			@NotNull String toplace, @Email String email, float price, Date traveldate, String pincode) {
		super();
		this.id = id;
		this.username = username;
		this.fromplace = fromplace;
		this.toplace = toplace;
		this.email = email;
		this.price = price;
		this.traveldate = traveldate;
		this.pincode = pincode;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getFromplace() {
		return fromplace;
	}

	public void setFromplace(String fromplace) {
		this.fromplace = fromplace;
	}

	public String getToplace() {
		return toplace;
	}

	public void setToplace(String toplace) {
		this.toplace = toplace;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Date getTraveldate() {
		return traveldate;
	}

	public void setTraveldate(Date traveldate) {
		this.traveldate = traveldate;
	}
	
	

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", username=" + username + ", fromplace=" + fromplace + ", toplace=" + toplace
				+ ", email=" + email + ", price=" + price + ", TravelDate="+traveldate+"]";
	}
}

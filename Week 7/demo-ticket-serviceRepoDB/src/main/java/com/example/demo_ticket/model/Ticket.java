package com.example.demo_ticket.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Ticket {

	@Id // ID will generate by default
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "[a-z]{2,}")
	@NotNull(message = "Username cant be null")
	@Column
	private String username;

	@NotNull
	@Size(min = 3, max = 100)
	@Column // Annotation used to create columns(Optional)
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

	@Min(1)
	@Max(10)
	@Column
	private int seats;

	@Future(message = "Date shoul be in future")
	private Date traveldate;

	@Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$")
	// @Pattern(regexp = "^[1-9]{1}[0-9]{5}$")
	private String pincode;

	public Ticket() {
	}

	public Ticket(int id, @NotNull(message = "Username cant be null") String username,
			@NotNull @Size(min = 3, max = 100) String fromplace, @NotNull String toplace, @NotNull @Email String email,
			@DecimalMin("99.9") @DecimalMax("10000") float price, @Min(1) @Max(10) int seats,
			@Future(message = "Date shoul be in future") Date traveldate,
			@Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$") String pincode) {
		super();
		this.id = id;
		this.username = username;
		this.fromplace = fromplace;
		this.toplace = toplace;
		this.email = email;
		this.price = price;
		this.seats = seats;
		this.traveldate = traveldate;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFrom_place() {
		return fromplace;
	}

	public void setFrom_place(String from_place) {
		this.fromplace = from_place;
	}

	public String getTo_place() {
		return toplace;
	}

	public void setTo_place(String to_place) {
		this.toplace = to_place;
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

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", username=" + username + ", fromplace=" + fromplace + ", toplace=" + toplace
				+ ", email=" + email + ", price=" + price + ", traveldate=" + traveldate + ", pincode=" + pincode + "]";
	}

}

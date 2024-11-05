package com.example.demo_rest;

import org.springframework.stereotype.Component;

@Component
public class Ticket {

	private int id;
	private String name;
	private String addr;
	private int num_of_seats;

	public Ticket() {

	}

	public Ticket(int id, String name, String addr, int num_of_seats) {
		super();
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.num_of_seats = num_of_seats;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getNum_of_seats() {
		return num_of_seats;
	}

	public void setNum_of_seats(int num_of_seats) {
		this.num_of_seats = num_of_seats;
	}

}

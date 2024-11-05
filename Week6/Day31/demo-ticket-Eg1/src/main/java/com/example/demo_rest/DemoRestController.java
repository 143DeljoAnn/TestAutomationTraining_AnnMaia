package com.example.demo_rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	public DemoRestController() {
		System.out.println("Constructor DemoRestController()");
	}

	@GetMapping("/hello")
	String met() {
		System.out.println("*******jjjjjjjjjjjjj************");
		return "Hello World";
	}

	@GetMapping("/ticket")
	Ticket getUser(@RequestParam("tid") int ticketid) {
		// localhost:8180/ticket?tid=1
		// 127.0.0.1:8180/ticket?tid=1
		return new Ticket(1, "Thor", "Asgard", 3);
	}

	@PostMapping("/book")
	// @RequestBody creates java object from request
	Ticket bookTicket(@RequestBody Ticket ticket) {
		System.out.println("Booking ticket: " + ticket);
		ticket.setId(100);
		return ticket;
	}

	@DeleteMapping("/cancel")
	String cancelTicket(@RequestParam("tid") int ticketid) {
		return "Ticket with id" + ticketid + " is cancelled";
	}

}

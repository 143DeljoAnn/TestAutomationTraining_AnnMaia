package com.example.demo_ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_ticket.exception.InvalidPlaceNameException;
import com.example.demo_ticket.exception.InvalidTicketIDException;
import com.example.demo_ticket.model.Ticket;
import com.example.demo_ticket.service.TicketService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ticket")
public class TicketRestController {

	@Autowired
	TicketService tservice;

	// GET /ticket/<ticketid>
	@GetMapping("/{tid}")
	ResponseEntity<Ticket> getTicket(@PathVariable("tid") int ticketid) {

		Ticket ticket = tservice.getTicketServ(ticketid);

		if (ticket == null) {
			throw new InvalidTicketIDException("No such ticket  exists");
		}

		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);

		/* when ticket id doesn't exist, status code 404, Ticket doesn't exist */
	}

	// GET/ticket/fromto/{fromplace}/{toplace}
	@GetMapping("/fromto/{fromPlace}/{toPlace}")
	ResponseEntity<List<Ticket>> getFromToTickets(@PathVariable String fromPlace, @PathVariable String toPlace) {
		List<Ticket> lticket = tservice.getTicketFromToPlace(fromPlace, toPlace);
		return new ResponseEntity<List<Ticket>>(lticket, HttpStatus.OK);
	}

	@GetMapping("/avgprice/{fromplace}")
	ResponseEntity<Float> getAveragePrice(@PathVariable String fromplace) {
		float avg = tservice.getAveragePrice(fromplace);
		return new ResponseEntity<Float>(avg, HttpStatus.OK);
	}

	@GetMapping("/economy/{fromPlace}/{toPlace}/{price}")
	ResponseEntity<List<Ticket>> getEconomyTickets(@PathVariable String fromPlace, @PathVariable String toPlace,
			@PathVariable float price) {
		List<Ticket> lticket = tservice.getEconomyTickets(fromPlace, toPlace, price);
		return new ResponseEntity<List<Ticket>>(lticket, HttpStatus.OK);
	}

	// searching tickets
	// all tickets of an User

	// POST /ticket/book, x-custom-hdr
	@PostMapping("/book")
	ResponseEntity<Ticket> bookTicket(@Valid @RequestBody Ticket ticket,
			@RequestHeader(value = "x-custom-hdr") String customhdr) {
		System.out.println("Custom http header values is " + customhdr);
		if (ticket.getTo_place() == null || ticket.getFrom_place() == null) {
			throw new InvalidPlaceNameException("Place Empty or null or doesnt Exist");
		}
		// assuming ticket id is given by client itself

		tservice.bookTicketServ(ticket);
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-response-hdr", "responsehdr");
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}

	// PUT /ticket/update

	@PutMapping("/update/{tid}")
	ResponseEntity<Ticket> update(@PathVariable("tid") Integer tid, @RequestBody Ticket ticket) {

		ticket = tservice.updateTicketServ(tid, ticket);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}

	// DELETE /ticket/<ticketid>

	@DeleteMapping("/{tid}")
	ResponseEntity<Integer> cancel(@PathVariable("tid") Integer ticketid) {
		Ticket ticket = tservice.cancelTicketServ(ticketid);
		if (ticket == null) {
			throw new InvalidTicketIDException("No such ticket  exists");
		}
		return new ResponseEntity<Integer>(ticketid, HttpStatus.OK);
	}

}

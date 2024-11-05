package com.example.demo_resttemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoClientService {

	private RestTemplate rClient = new RestTemplate();
	private final String BASE_URL = "http://localhost:8080/ticket/";

	public ResponseEntity<Ticket> getTickets(int ticketid) {
		ResponseEntity<Ticket> reticket = rClient.getForEntity(BASE_URL + ticketid, Ticket.class);
		return reticket;
	}

	public ResponseEntity<Ticket> bookTicket(Ticket ticket) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("x-custom-hdr", "abcd");

		HttpEntity<Ticket> request = new HttpEntity<Ticket>(ticket, httpHeaders);
		ResponseEntity<Ticket> reticket = rClient.postForEntity(BASE_URL + "book", request, Ticket.class);

		return reticket;
	}

	public ResponseEntity<Ticket> updateTicket(int ticketid, Ticket ticket) {
		// http://localhost:8080/ticket/update/17
		/*
		 * rClient.put(BASE_URL+"update/"+ticketid, ticket);
		 * 
		 * ResponseEntity<Ticket> rticket = rClient.getForEntity(BASE_URL+ticketid,
		 * Ticket.class);
		 */
		
		HttpEntity<Ticket> request = new HttpEntity<>(ticket);
		ResponseEntity<Ticket> rticket = 
				rClient.exchange(BASE_URL+"update/"+ticketid, 
						HttpMethod.PUT, request, Ticket.class);
		return rticket;
	}
	
	public void cancelTicket(int ticketid) {
		rClient.delete(BASE_URL+ticketid);
	}

}

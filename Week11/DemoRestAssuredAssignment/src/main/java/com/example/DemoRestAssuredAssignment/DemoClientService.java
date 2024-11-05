package com.example.DemoRestAssuredAssignment;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoClientService {

	private RestTemplate rClient = new RestTemplate();
	private final String BASE_URL ="http://localhost:8080/ticket/";
	
	public ResponseEntity<Ticket> getTicket(@PathVariable int ticketid){
		ResponseEntity<Ticket> reTicket = rClient.getForEntity(BASE_URL+ticketid,Ticket.class);
		return reTicket;
	}
	
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("x-custom-hdr","abcd");
		HttpEntity<Ticket> request = new HttpEntity<Ticket>(ticket,httpHeaders);
		ResponseEntity<Ticket> reticket=
				rClient.postForEntity(BASE_URL+"book",request,Ticket.class);
		return reticket;
	}
	
	public ResponseEntity<Ticket> updateTicket(@PathVariable int ticketid,@RequestBody Ticket ticket){
	/*	rClient.put(BASE_URL+"update/"+ticketid, ticket);
		ResponseEntity<Ticket> rTicket = rClient.getForEntity(BASE_URL+ticketid,Ticket.class);
		return rTicket;
		*/
		HttpEntity<Ticket> request = new HttpEntity<>(ticket);
		ResponseEntity<Ticket> rticket=rClient.exchange(BASE_URL+"update/"+ticketid, HttpMethod.PUT,request,Ticket.class);
		return rticket;
	}
	
	public ResponseEntity<String> deleteTicket(@PathVariable int ticketid){
		rClient.delete(BASE_URL+ticketid);
		return new ResponseEntity<String>("Ticket "+ticketid+" is deleted", HttpStatus.OK);
	}
}
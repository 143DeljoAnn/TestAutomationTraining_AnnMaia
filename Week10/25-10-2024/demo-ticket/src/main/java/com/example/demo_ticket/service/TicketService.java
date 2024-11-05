package com.example.demo_ticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_ticket.model.Ticket;
import com.example.demo_ticket.repository.TicketRepository;

import jakarta.annotation.PostConstruct;

@Service
public class TicketService {
	// automatically adding code for DB interaction
	@Autowired
	private TicketRepository ticketRepo;
	// Dependency Injection => DI

	public TicketService(){
		System.out.println("----------------TicketService()-----------------");
	}
	
	@PostConstruct
	public void met(){
		ticketRepo.met10("user1");
		
		List<Ticket> lticket = ticketRepo.met9("user1");
		for(Ticket t:lticket) {
			System.out.println("==================="+t+"===================");
		}
	}
	
	public Ticket getTicketServ(int ticketid) {
		Optional<Ticket> oticket = ticketRepo.findById(ticketid);
		
		//ticketRepo.findByFrom_placeAndTo_place("", "");
		return oticket.get();
	}

	public Ticket bookTicketServ(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	public List<Ticket> getTicketFromToPlace(String fromplace, String toplace){
		return ticketRepo.findByFromplaceOrToplace(fromplace, toplace);
	}
	
	public float getAveragePrice(String fromplace) {
		List<Ticket> lticket = ticketRepo.met(fromplace);
		float avg_price = 0;
		for(Ticket t:lticket) {
			avg_price += t.getPrice();
		}
		
		avg_price = avg_price/lticket.size();
		/*
		lticket.stream().map(Ticket::getPrice).reduce((total, price)-> total + price
		 */
		return avg_price;
	}
	
	public List<Ticket> getEconomyTickets(String fromplace, String toplace, float price){
		return ticketRepo.findByFromplaceAndToplaceAndPriceLessThan(fromplace, toplace, price);
	}
	public Ticket updateTicketServ(int tid, Ticket ticket) {
		Ticket eTicket = ticketRepo.findById(tid).get();
		eTicket.setFromplace(ticket.getFromplace());
		eTicket.setToplace(ticket.getToplace());
		eTicket.setPrice(ticket.getPrice());
		
		return ticketRepo.save(eTicket);
	}

	public Ticket cancelTicketRepo(int ticketid) {
		Ticket ticket = ticketRepo.findById(ticketid).get();
		ticketRepo.deleteById(ticketid);
		return ticket;
	}

}

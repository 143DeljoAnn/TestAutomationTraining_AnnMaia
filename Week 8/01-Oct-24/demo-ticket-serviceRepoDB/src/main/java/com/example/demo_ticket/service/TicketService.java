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
	@Autowired
	TicketRepository ticketRepo;
	// Dependency Injection

	public TicketService() {
		System.out.println("------------TicketService()----------");
	}

	@PostConstruct
	public void met() {
		ticketRepo.met10("user1");
		List<Ticket> lticket = ticketRepo.met9("user1");
		for (Ticket t : lticket) {
			System.out.println("======" + t + "=====");
		}

	}

	public Ticket getTicketServ(int ticketid) {
		Optional<Ticket> oticket = ticketRepo.findById(ticketid);
		return oticket.get();
	}

	public List<Ticket> getTicketFromToPlace(String fromPlace, String toPlace) {
		return ticketRepo.findByFromplaceAndToplace(fromPlace, toPlace);
	}

	public float getAveragePrice(String fromplace) {
		List<Ticket> lticket = ticketRepo.met(fromplace);
		float sum = 0;
		for (Ticket t : lticket) {
			sum += t.getPrice();
		}
		float avg_price = sum / lticket.size();

		// lticket.stream().map(Ticket::getPrice).reduce(()total,price)
		return avg_price;
	}

	public List<Ticket> getEconomyTickets(String fromPlace, String toPlace, float price) {
		return ticketRepo.findByFromplaceAndToplaceAndPriceLessThan(fromPlace, toPlace, price);
	}

	public Ticket bookTicketServ(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	public Ticket updateTicketServ(int tid, Ticket ticket) {
		Ticket eTicket = ticketRepo.findById(tid).get();
		eTicket.setFrom_place(ticket.getFrom_place());
		eTicket.setTo_place(ticket.getTo_place());
		eTicket.setPrice(ticket.getPrice());
		return ticketRepo.save(eTicket);
	}

	public Ticket cancelTicketServ(int ticketid) {
		Ticket ticket = ticketRepo.findById(ticketid).get();
		ticketRepo.deleteById(ticketid);
		return ticket;
	}

}

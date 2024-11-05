package com.example.demo_ticket.exception;

public class InvalidTicketIDException extends RuntimeException {
	public InvalidTicketIDException(String message) {
		super(message);
	}

}

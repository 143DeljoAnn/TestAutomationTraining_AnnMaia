package com.example.demo_ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.demo_ticket","com.controller"})
public class DemoTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTicketApplication.class, args);
	}

}

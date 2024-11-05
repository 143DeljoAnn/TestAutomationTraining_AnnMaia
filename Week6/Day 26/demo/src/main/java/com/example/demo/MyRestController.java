package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@GetMapping("/hello")
	public String met1() {
		return "Hello123";
	}

	@GetMapping("/url")
	public Person met2() {
		return new Person(1, "Thor");
	}
}

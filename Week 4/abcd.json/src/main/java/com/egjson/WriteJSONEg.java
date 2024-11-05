package com.egjson;

import java.io.FileOutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WriteJSONEg {

	public static void main(String[] args) throws Exception {

		// Address addr[]= new Address[2];
		Address[] addr = { new Address("Street1", "City1", 654321), new Address("Stree2", "City2", 123456) };

		Person obj = new Person(46, "Ravi", addr);

		ObjectMapper mapper = new ObjectMapper();

		FileOutputStream fos = new FileOutputStream("person.json");

		mapper.writeValue(fos, obj);

		String pjson = mapper.writeValueAsString(obj);

		System.out.println("JSON file has been created, please check " + pjson);
	}
}

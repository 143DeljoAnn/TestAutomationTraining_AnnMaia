package com.egjson;

import java.io.FileInputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJSONEg {
	public static void main(String[] args) throws Exception {

		// create a ObjectMapper and Fileinput stream objects to read from Json
		ObjectMapper omapper = new ObjectMapper();
		FileInputStream fis = new FileInputStream("./person.json");

		// we have to pass the object and the return type i.e Product.class
		Person obj = omapper.readValue(fis, Person.class);

		System.out.println(obj);
	}

}

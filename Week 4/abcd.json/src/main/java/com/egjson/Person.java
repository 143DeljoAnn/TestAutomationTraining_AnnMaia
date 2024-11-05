package com.egjson;

import java.util.Arrays;

public class Person {

	private int agee;
	private String Name;
	private Address[] address;

	public int getAgee() {
		return agee;
	}

	public void setAgee(int age) {
		this.agee = age;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Address[] getAddress() {
		return address;
	}

	public void setAddress(Address[] address) {
		this.address = address;
	}

	public Person() {

	}

	public Person(int age, String name, Address[] address) {
		super();
		this.agee = age;
		Name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [age=" + agee + ", Name=" + Name + ", address=" + Arrays.toString(address) + "]";
	}

}

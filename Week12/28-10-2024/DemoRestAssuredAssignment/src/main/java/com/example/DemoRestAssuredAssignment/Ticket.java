package com.example.DemoRestAssuredAssignment;
public class Ticket {

	private int id;
	

	private String username;


	private String fromplace;
	

	private String toplace;
	

	private float price;

	public Ticket() {}
	
	public Ticket(int id, String from_place, String to_place, float price, String username) {
		super();
		this.id = id;
		this.fromplace = from_place;
		this.toplace = to_place;
		this.price = price;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getFromplace() {
		return fromplace;
	}

	public void setFromplace(String fromplace) {
		this.fromplace = fromplace;
	}

	public String getToplace() {
		return toplace;
	}

	public void setToplace(String toplace) {
		this.toplace = toplace;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", username=" + username + ", fromplace=" + fromplace + ", toplace=" + toplace
				+ ", price=" + price + "]";
	}
	

}
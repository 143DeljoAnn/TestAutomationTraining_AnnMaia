package Day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

class City{
	private String name;
	private long pin;
	private String CapitalCity;
	
	//constructor
	public City(String name, long pincode, String capitalCity) {
		super();
		this.name = name;
		this.pin = pincode;
		CapitalCity = capitalCity;
	}
	
	//getter, setter - TBD
	@Override
	public int hashCode() {
		return Objects.hash(CapitalCity, name, pin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(CapitalCity, other.CapitalCity) && Objects.equals(name, other.name)
				&& pin == other.pin;
	}
	
	//toString
	@Override
	public String toString() {
		return "City [Name=" + name + ", Pincode=" + pin + ", CapitalCity=" + CapitalCity + "]";
	}
		
	
}

public class ListExample {

	public static void main(String[] args) {
		//create List
		List<City> cities = new ArrayList<City>();
		//Scanner scnr = new Scanner(System.in);
		
		//add City Objects to List
		
		cities.add(new City("Nam1", 111, "Capital1"));
		cities.add(new City("Nam2", 222, "Capital2"));
		cities.add(new City("Nam3", 333, "Capital3"));
		
		display(cities,"-------------Before Reverse--------------");
		Collections.reverse(cities);
		
		display(cities,"-------------After reverse---------------");
		
		
		
	}
	
	static void display(List<City> lcity, String mssg) {
		System.out.println(mssg);
		//iterate and display
		Iterator<City> itr = lcity.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}

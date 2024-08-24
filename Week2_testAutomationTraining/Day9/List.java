package Day9;


import java.util.*;

class CityEg1 {
	private String name;
	private long pincode;
	private String state;
	
	//constructor
	public CityEg1(String name, long pincode, String capital_city) {
		this.name = name;
		this.pincode = pincode;
		this.state = capital_city;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "City [name=" + name + ", pincode=" + pincode + ", state=" + state + "]";
	}
}

public class List {
public static void main(String[] args) {
	//create List
	LinkedList<CityEg1> cities = new LinkedList<CityEg1>();
	Scanner scnr = new Scanner(System.in);
	
	System.out.println("Please enter number of cities");
	int n = scnr.nextInt();
	
	//add City objects to List
		
	for(int i=1;i<=n;i++) {
	System.out.println("Please enter city"+i+" name");
	String icity = scnr.next();
	
	System.out.println("Please enter pincode"+i);
	long ipincode = scnr.nextLong();
	
	System.out.println("Please enter State"+i+" name");
	String istate = scnr.next();
	
	cities.add(new CityEg1(icity, ipincode, istate));
	}
	//iterate and display
	Iterator<CityEg1> itr = cities.iterator();
	
	while(itr.hasNext()){
		System.out.println(itr.next());
	}
	
	
}
}



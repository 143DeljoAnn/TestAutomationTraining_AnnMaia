package Day9;


import java.util.ArrayList;
import java.util.List;

class CityEg{
	private String name;
	private long pincode;
	private String CapitalCity;
	
	//constructor
	public CityEg(String name, long pincode, String capitalCity) {
		super();
		this.name = name;
		this.pincode = pincode;
		CapitalCity = capitalCity;
	}
	
	//getter, setter - TBD
	
	//toString
	@Override
	public String toString() {
		return "City [Name=" + name + ", Pincode=" + pincode + ", CapitalCity=" + CapitalCity + "]";
	}
	
		
	
}

public class ListwithEnhanced {

	public static void main(String[] args) {
		//create List
		List<CityEg> cities = new ArrayList<CityEg>();
		
		//add City Objects to List
		
		cities.add(new CityEg("city1", 00001, "Capital1"));
		cities.add(new CityEg("city2", 00002, "Capital2"));
		cities.add(new CityEg("city3", 00003, "Capital3"));
		
		//iterate with enhanced for
		System.out.println("-----iterate with enhanced for--------");
		for(CityEg c: cities) {
			System.out.println(c);
		}
		
		//iterate with for
		System.out.println("-------iterate with for---------");
		for(int i = 0; i<cities.size();i++) {
			System.out.println(cities.get(i));
		}
		
	}
}



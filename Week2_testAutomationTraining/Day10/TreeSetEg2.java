package Day10;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


class Country{
	private String name;
	private double gdp;
	
	public Country(String name, double gdp) {
		super();
		this.name = name;
		this.gdp = gdp;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGdp() {
		return gdp;
	}
	public void setGdp(double gdp) {
		this.gdp = gdp;
	}
	@Override
	public String toString() {
		return "Country [name=" + name + ", gdp=" + gdp + "]";
	}
	
	
	
}


public class TreeSetEg2 {
	public static void main(String[] args) {
		TreeSet<Country> tss = new TreeSet<Country>(new MyComparator1());
		
		
		
		//TreeSet<Country> cts = new TreeSet<Country>();
		tss.add(new Country("Country1", 10.55));
		tss.add(new Country("Country2", 11.66));
		tss.add(new Country("Country3", 12.77));
		
Iterator<Country> itrc = tss.iterator();
		
		while(itrc.hasNext()) {
			System.out.println(itrc.next());
		}
	
	}	
}


class MyComparator1 implements Comparator<Country>{
	@Override
	public int compare(Country c1, Country c2) {
		return (int)(c2.getGdp()-c1.getGdp());
	}

	

}
package Day13;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;


class CountryExample4{
	private String name;
	private double gdp;
	
	public CountryExample4(String name, double gdp) {
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
		return "Country [Name =" + name + ", gdp =" + gdp + "]";
	}
		
	
}


public class TreeSetExample4 {
	public static void main(String[] args) {
			
		TreeSet<CountryExample4> tss = new TreeSet<CountryExample4>(
				(c1,c2)->(int)(c2.getGdp()-c1.getGdp())
				);
		
		tss.add(new CountryExample4("Country1", 10.11));
		tss.add(new CountryExample4("Country2", 5.22));
		tss.add(new CountryExample4("Country3", 15.33));
		
		Iterator<CountryExample4> itrc = tss.iterator();
		
		/*while(itrc.hasNext()) {
			System.out.println(itrc.next());
		}
		*/
	
		
		CountryExample4 c4min = Collections.min(tss, (c1,c2)->c1.getName().compareTo(c2.getName()));
		System.out.println("Minimum country is "+c4min);
		
		CountryExample4 c4max = Collections.max(tss, (c1,c2)->c1.getName().compareTo(c2.getName()));
		System.out.println("Maximum country is "+c4max);
		
		
	}	
}



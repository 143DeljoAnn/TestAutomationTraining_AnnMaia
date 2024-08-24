package Day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

//import Collections.State;


public class StreamEg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list=Arrays.asList(3,4,15,12,20);
		//filter(),map(),reduce();
		list.stream().filter((e)->e>10).map((e)->2*e).forEach((e)->{System.out.println(e);});
		
		
		ArrayList<Integer> alist=new ArrayList<>(list);
		Optional<Integer> iresult =alist.stream().filter((e)->e>10).reduce((i1,i2)->{return i1>i2?i1:i2;}
		);
		
		HashSet<State> hmss=new HashSet<>();
		
		hmss.add(new State("StateName1", 1234));
		hmss.add(new State("StateName2", 2234));
		hmss.add(new State("StateName3", 5734));
		hmss.add(new State("StateName4", 3234));
		
		
	}

}

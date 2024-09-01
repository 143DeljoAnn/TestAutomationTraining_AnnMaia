package Day12;


import java.util.List;

public class StringExample {
	public static void main(String[] args) {
		String str = "This,is,to,test";
					
		//use split() to tokenize given string
		
		String[] arr = str.split(",");
		for(String s : arr) {
			System.out.println(s);
		}
	}
}


package Day15;


import java.util.Set;
import java.util.TreeMap;


public class ChatMessageExample {
	public static void main(String[] args) {
		TreeMap<String, String> hmss = new TreeMap<>((s1, s2) -> s1.compareTo(s2));

		hmss.put("Name1", "Message01");
		hmss.put("Name2", "Message02");
		hmss.put("Name3", "Message03");
		hmss.put("Name4", "Message04");
		hmss.put("Name5", "Message05");

		Set<String> ss = hmss.keySet();

		for (String item_key : ss) {
			System.out.println(item_key + " ----> " + hmss.get(item_key));
		}

	}

}
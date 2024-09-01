package Day15;


import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;


class ChatExample1{
	private String sender_Name ;
	private String msg;
	public ChatExample1(String sender_Name, String msg) {
		super();
		this.sender_Name = sender_Name;
		this.msg = msg;
	}
	
	public String getSender_Name() {
		return sender_Name;
	}

	public void setSender_Name(String sender_Name) {
		this.sender_Name = sender_Name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Chat Details [Sender_Name =" + sender_Name + ", Message =" + msg + "]";
	}
	
}
	
public class ChatMessageToSubjectExample {

	public static void main(String[] args) {
		
		//1st way
		/*
		 * class TSComparator implements Comparator<Chats1>{
		 * 
		 * @Override public int compare(Chats1 s1, Chats1 s2) { return
		 * s2.getSender_Name().compareTo(s1.getSender_Name()); }
		 * 
		 * }
		 */

		//2nd way
		
		/*
		 * Comparator<Chats1> mcmp = new Comparator<Chats1>() {
		 * 
		 * @Override public int compare(Chats1 s1, Chats1 s2) { return
		 * s2.getSender_Name().compareTo(s1.getSender_Name()); }
		 * 
		 * 
		 * };
		 * 
		 * TreeSet<Chats1> cmsgs = new TreeSet<>(mcmp);
		 */	
		
		//3rd way
		/*
		 * TreeSet<Chats1> cmsgs = new TreeSet<>(new Comparator<Chats1>() {
		 * 
		 * @Override public int compare(Chats1 s1, Chats1 s2) { return
		 * s2.getSender_Name().compareTo(s1.getSender_Name()); }
		 * 
		 * });
		 */
		
		//4th way
		/*
		 * TreeSet<Chats1> cmsgs = new TreeSet<>((s1,s2)->{ return
		 * s2.getSender_Name().compareTo(s1.getSender_Name()); });
		 */
		
		//5th way
		
		TreeSet<ChatExample1> cmsgs = new TreeSet<>((s1,s2)-> s2.getSender_Name().compareTo(s1.getSender_Name()+s2.getMsg()));
		
		cmsgs.add(new ChatExample1("P13", "D"));
		cmsgs.add(new ChatExample1("P2", "S"));
		cmsgs.add(new ChatExample1("P9", "d"));
		cmsgs.add(new ChatExample1("P8", "N"));
		cmsgs.add(new ChatExample1("P13", "e"));
		cmsgs.add(new ChatExample1("P5", "Y"));
		cmsgs.add(new ChatExample1("P8", "I"));
		cmsgs.add(new ChatExample1("P9", "completed"));
		display(cmsgs);
		
		//write a lambda which sorts based on msg order(assending)
		
		//Chats1 c = Collections.min(cmsgs, ((s1,s2)-> s2.getMsg().compareTo(s1.getMsg())));
		
		//display(cmsgs);
		System.out.println("==============================");
		cmsgs.stream().filter((e)->{return e.getSender_Name().equalsIgnoreCase("P13");})
		.forEach((item)->{System.out.println(item.getMsg());});
		System.out.println("==============================");
		//System.out.println(c);
		
	}
	


	static void display(TreeSet<ChatExample1> ts) {
		for (ChatExample1 str : ts) {
			System.out.println(str);
		}
	}
	
	
}
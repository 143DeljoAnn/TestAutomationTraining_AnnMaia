package Day14;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Chats{
	private String sender_Name ;
	private String msg;
	public Chats(String sender_Name, String msg) {
		super();
		this.sender_Name = sender_Name;
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Chat Details [Sender_Name =" + sender_Name + ", Message =" + msg + "]";
	}
	
	
}
public class ChatMessageAll {
	public static void main(String[] args) {
		List<Chats> msgs = new LinkedList<>();
		//create chats objects and add to above all
		
		msgs.add(new Chats("P13", "D"));
		msgs.add(new Chats("P2", "S"));
		msgs.add(new Chats("P9", "d"));
		msgs.add(new Chats("P8", "N"));

		msgs.add(new Chats("P13", "e"));
		msgs.add(new Chats("P5", "Y"));
		msgs.add(new Chats("P8", "I"));
		msgs.add(new Chats("P9", "Completed"));
		//iterate and display
		System.out.println("Original List");
		display(msgs);
		//reverse and display
		System.out.println("List after reverse");
		Collections.reverse(msgs);
		display(msgs);
		
		//again reverse and display
		System.out.println("List after reverse again");
		Collections.reverse(msgs);
		display(msgs);
	}
	
	static void display(List<Chats> list) {
		for(Chats str : list) {
			System.out.println(str+"\t");
		}
	}
}

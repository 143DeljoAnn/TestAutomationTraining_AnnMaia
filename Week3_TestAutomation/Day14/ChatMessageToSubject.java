package Day14;


import java.util.Comparator;
import java.util.TreeSet;

//use Treeset for above application, store chat Objects,sort based on ascending order
class Chat{
	private String sender_Name ;
	private String msg;
	public Chat(String sender_Name, String msg) {
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
	
public class ChatMessageToSubject {

	public static void main(String[] args) {
		
		TreeSet<Chat> cmsgs = new TreeSet<>(new OComparator());
		cmsgs.add(new Chat("P13", "D"));
		cmsgs.add(new Chat("P2", "S"));
		cmsgs.add(new Chat("P9", "d"));
		cmsgs.add(new Chat("P8", "N"));

		cmsgs.add(new Chat("P13", "e"));
		cmsgs.add(new Chat("P5", "Y"));
		cmsgs.add(new Chat("P8", "I"));
		cmsgs.add(new Chat("P9", "Completed"));
		display(cmsgs);
			
		
	}
	

	static void display(TreeSet<Chat> ts) {
		for (Chat str : ts) {
			System.out.println(str);
		}
	}
	
	
}
class OComparator implements Comparator<Chat>{

	@Override
	public int compare(Chat s1, Chat s2) {
		return s1.getSender_Name().compareTo(s2.getSender_Name());
	}
	
}

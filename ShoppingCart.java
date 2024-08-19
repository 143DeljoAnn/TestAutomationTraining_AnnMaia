package Assignment1;

public class ShoppingCart {
	private int pid=12;
	private String pname="Shirt";
	private static int num_of_products=100;

	public ShoppingCart(int pid, String pname) {
		super();
		this.pid = pid;
		this.pname = pname;
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	

	}
   

	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}

}

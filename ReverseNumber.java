package Assignment1;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=132,r=0,a;
		while(n!=0) {
			a=n%10;
			r=r*10+a;
			n=n/10;
		
		}
		
		System.out.println(r);
	}

}

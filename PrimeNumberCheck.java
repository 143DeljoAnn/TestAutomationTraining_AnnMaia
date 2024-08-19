package Assignment1;

public class PrimeNumberCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=31;
		boolean isprime=true;
		for( int i=2; i<=n/2 ;i++) {
			if(n%i==0) {
				isprime=false;
				break;
			}
		}if(isprime) {
			System.out.println(n + " is prime");
		}else {
			System.out.println(n + " is not prime");
		}
	}

}

package Assignment1;

public class FactorialPrimeAsMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		System.out.println("factorial of "+n + " is "+ factorial(n));
		primeSeries(n);

	}	


 private static void primeSeries(int n) {
		// TODO Auto-generated method stub
	 
	 for (int i=0;i<=n;i++) {
		 boolean isprime=true;
		 for(int j=2;j<=i/2;j++) {
			 if(i%j==0) {
					isprime=false;
					break;
				}
		 }if(isprime)
		 {
			 System.out.println(i);
		 }
	 }
	
	}


static int factorial(int n) {
		// TODO Auto-generated method stub
	int fact=1;
	for(int i=1;i<=n;i++) {
		fact=fact*i;
		
	}
		return fact;
	
 }
}



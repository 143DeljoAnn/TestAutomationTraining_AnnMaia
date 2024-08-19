package Assignment1;

public class FibanociSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0,b=1,c=0;
		System.out.print(a+" "+b);
		do {
			c=a+b;
			if(c<1000) {
				System.out.print(" "+c);
			}
			a=b;
			b=c;
				
		}while(c<1000);

	}

}

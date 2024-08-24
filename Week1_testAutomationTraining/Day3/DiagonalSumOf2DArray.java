package Day3;

public class DiagonalSumOf2DArray {

public static void main(String[] args) {
		
		int pincome[][] = { { 1, 2, 3, 4 }, { 4, 5, 6, 8 },{ 7, 8, 6, 2 },{ 1, 5, 3, 6 } }; 
		print(pincome);
		
		System.out.println("Sum of diagnoal = "+sumOfDiagonalElements(pincome));
		
	}
	
	static void print(int[][] arr) {
		System.out.println("----------------Display Begin--------------");
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+ "\t");
			}
			System.out.println("");
		}
		System.out.println("----------------Display End--------------");
	}


static int sumOfDiagonalElements(int[][] arr) {
	int sum = 0;
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[0].length;j++) {
					if(i==j||(i+j)==(arr.length-1)) {
						sum+=arr[i][j];
					}
				}
			}
			return sum;
	}
}

package Day3;

public class Arraysort {
	
	public static void main(String[] args) {
		

			int pincome[] = {82, 52, -2, 31, 26, 11 };

			System.out.println("Array before sorting...");
			print(pincome);
			
			int[] rpincome1  = sortArrayInDecending(pincome, true);
			System.out.println("Array after sorting......");
			print(rpincome1);
			
			int[] rpincome2  = sortArrayInDecending(pincome, false);
			System.out.println("Array after sorting......");
			print(rpincome1);
				}
			
			
			static void print(int[] arr) {
					System.out.println("----------------Display Begin--------------");
			for (int i = 0; i < arr.length; i++) {
						System.out.println("PerCapita income of City " + i + " is " + arr[i]);
					}
					System.out.println("----------------Display End--------------");
				}

			
			
			
			static int[] sortArrayInDecending(int[] avalues, boolean flag) {
				
				if(flag) {
					for (int i = 0; i < avalues.length; i++) {
						for (int j = 0; j < avalues.length - 1 - i; j++) {
						if (avalues[j] < avalues[j + 1]) {
						int tmp = avalues[j];
											avalues[j] = avalues[j + 1];
											avalues[j + 1] = tmp;
										}
									}
								}
						return avalues;
							}else {
								for (int i = 0; i < avalues.length; i++) {
									for (int j = 0; j < avalues.length - 1 - i; j++) {
									if (avalues[j] > avalues[j + 1]) {
									int tmp = avalues[j];
														avalues[j] = avalues[j + 1];
														avalues[j + 1] = tmp;
													}
												}
											}
									return avalues;
							}
				}
				
			}
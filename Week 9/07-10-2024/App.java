package AssignmentOct07_Singleton;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		int arr[] = new int[5];
		Scanner scnr = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.println("Enter next value, and press enter");
			int val = scnr.nextInt();
			arr[i] = val;
		}

		ArrayUtils obj = ArrayUtils.getInstance(arr);
		int min_result = obj.min();

		ArrayUtils obj1 = ArrayUtils.getInstance(arr);
		ArrayUtils obj2 = ArrayUtils.getInstance(arr);
		System.out.println(min_result);
		System.out.println(obj);
		System.out.println(obj1);
		System.out.println(obj2);
	}
}
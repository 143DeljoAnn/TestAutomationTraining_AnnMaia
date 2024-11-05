package AssignmentOct07_Singleton;

import java.util.Arrays;

public class minStringInArray {

	public static void main(String[] args) {
		String[] arr = { "abc", "aab", "aaab", "abb", "abb", "aaaa" };
		Arrays.sort(arr);
		String min = arr[0];
		String max = arr[arr.length - 1];
		System.out.println("Minimum String is " + min);
		System.out.println("Maximum String is " + max);

		minSortString(arr);
		maxSortString(arr);
	}

	public static void minSortString(String[] arr) {

		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i].compareToIgnoreCase(arr[i + 1]) > 0) {
					String temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
		System.out.println("Minimum String is " + arr[0]);

	}

	public static void maxSortString(String[] arr) {

		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i].compareToIgnoreCase(arr[i + 1]) < 0) {
					String temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
		System.out.println("Minimum String is " + arr[0]);

	}
}

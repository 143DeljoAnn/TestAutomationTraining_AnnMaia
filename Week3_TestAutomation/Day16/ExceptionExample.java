package Day16;

public class ExceptionExample {

	/*
	 * public static void main(String[] args) { main(args); }
	 */
	static void met() throws Exception {
		String str = "abcd";
		int val = Integer.parseInt(str);

		val *= 1.1;
		System.out.println(val);
	}
}

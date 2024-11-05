package Programs.Day18;

public class ExceptionEg1 {


		/*
		 * public static void main(String[] args) { main(args); }
		 */
		static void met() throws Exception {
			String str = "dfdf";
			int val = Integer.parseInt(str);

			val *= 1.1;
			System.out.println(val);
		}
	

}

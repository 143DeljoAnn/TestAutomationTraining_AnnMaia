package Day16;


public class ExceptionHandlingExample {
	public static void main(String[] args) {

		/*
		 * try { String str = "dfdf"; int val = Integer.parseInt(str);
		 * 
		 * val *= 1.1; System.out.println(val); } catch (Exception e) {
		 * System.out.println("Exception Occured.....Pls retry with valid input"); }
		 */

		try {
			// Exception Exmaple 1
			int arr[] = { 1, 2, 3, 4, 5 };
			for (int i = 0; i <= arr.length; i++) {
				System.out.println(arr[i]);
			}

			// Exception Exmaple 2
			String str = "abcd";
			String substr = str.substring(2, 9);
			System.out.println(substr);

			ExceptionExample.met();
			// ExceptionHandlingEg.met();
		} catch (StringIndexOutOfBoundsException se) {
			System.out.println("String IndexOutOfBounds Exception" + se);

		} catch (ArrayIndexOutOfBoundsException ae) {
			System.out.println("String IndexOutOfBounds Exception" + ae);
		} catch (NumberFormatException ne) {
			System.out.println("String IndexOutOfBounds Exception" + ne);
		}

		catch (Exception e) {
			System.out.println("Exception Occured.....Pls retry with valid input");
			e.printStackTrace();
		}

	}

}
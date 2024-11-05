package Programs.Day20;


//to print characters individually from a string using multi threading concept
class PrintChars extends Thread {

	String string1 = "Characters to print individually";

	@Override
	public void run() {
		try {

			for (int i = 0; i < string1.length(); i++) {
				System.out.print(string1.charAt(i)+" ");

				Thread.sleep(30);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

public class Multithreading2 {

	static String string1 = "This to print individual characters";

	public static void main(String[] args) {

		try {

			PrintChars thread = new PrintChars();
			thread.start();
			for (int i = 0; i < string1.length(); i++) {
				System.out.print(string1.charAt(i)+" ");
				Thread.sleep(25);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

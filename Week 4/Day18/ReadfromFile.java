package Programs.Day18;


import java.io.FileReader;

public class ReadfromFile {

	public static void main(String[] args) throws Exception {

		FileReader fis = new FileReader("./xyz.txt");

		int character;

		while ((character = fis.read()) != -1) {
			System.out.print((char) character);
		}

		fis.close();
	}

}

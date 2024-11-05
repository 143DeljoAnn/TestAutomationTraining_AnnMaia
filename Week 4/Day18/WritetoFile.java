package Programs.Day18;


import java.io.FileWriter;

public class WritetoFile {

	public static void main(String[] args) throws Exception {

		FileWriter fos = new FileWriter("./xyz.txt", true);

		String msg = "Hello, How are you?";

		fos.write(msg);

		fos.close();

	}

}

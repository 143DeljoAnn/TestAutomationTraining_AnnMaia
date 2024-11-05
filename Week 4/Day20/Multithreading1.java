package Programs.Day20;


class PrintOdd extends Thread {

	@Override
	public void run() {
		try{
		for (int i = 1; i < 100; i += 2) {
			System.out.println("Child Thread" + i);
			Thread.sleep(30);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

public class Multithreading1 {
	public static void main(String[] args) {
		
		try{
		PrintOdd thread = new PrintOdd();
		
		thread.start();
		
		for(int i = 0; i < 100; i+=2){
			System.out.println("Main Thread:"+i);
			Thread.sleep(25);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}


package Programs.Day21;


/*
Write a class which implements Runnable interface.
Implement public void run() method in class created above.
Write business logic which need to be executed in new thread, in run() method of step2.
In main method Create an object of Class of Step1
 */

class ChildThread implements RunnableEg, java.lang.Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 200; i += 3) {
			try {
				System.out.println("Child Thread: " + i);
				Thread.sleep(20);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}

public class Runnable {
	public static void main(String[] args) throws Exception {

		// create a thread for child class
		Thread t = new Thread(new ChildThread());
		t.start();

		for (int j = 0; j < 200; j += 2) {
			System.out.println("Main Thread: " + j);
			Thread.sleep(25);
		}
	}
}

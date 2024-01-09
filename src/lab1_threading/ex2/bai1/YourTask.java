package lab1_threading.ex2.bai1;

import lab1_threading.ex1.bai2.AnotherTask;

public class YourTask implements Runnable {

	@Override
	public void run() {
		try {
			Thread t = new Thread(new AnotherTask("Another task", 10));
			t.start();
			for (int i = 0; i < 8; i++) {
				System.out.println("Your Task #" + i);
				if(i == 5) {
					t.join();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

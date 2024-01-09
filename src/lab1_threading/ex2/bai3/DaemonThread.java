package lab1_threading.ex2.bai3;

public class DaemonThread extends Thread {
	public void run() {
		System.out.println("Entering run method");
		try {
			System.out.println("In run method: currentThrea() is " 
					+ Thread.currentThread());
			while(true) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				System.out.println("In run method: woke up again");
			}
		} finally {
			System.out.println("Leaving run method");
		}
	}
	public static void main(String[] args) throws Exception {
		System.out.println("Entering main method");
		DaemonThread thread = new DaemonThread();
		
		thread.setDaemon(true);
		
		thread.start();
		Thread.sleep(3000);
		System.out.println("Leaving main method");
	}
}

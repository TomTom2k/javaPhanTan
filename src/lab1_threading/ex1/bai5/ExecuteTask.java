package lab1_threading.ex1.bai5;

public class ExecuteTask {
	public static void main(String[] args) {
		Runnable r1 = new CheckPrimeNumber(12);
		Runnable r2 = new CheckPrimeNumber(11);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}

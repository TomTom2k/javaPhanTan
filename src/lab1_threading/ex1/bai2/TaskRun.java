package lab1_threading.ex1.bai2;

public class TaskRun {
	public static void main(String[] args) {
		Runnable r1 = new AnotherTask("Collect Task", 15);
		Runnable r2 = new AnotherTask("Process", 19);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}

package lab1_threading.ex1.bai4;

public class ExecuteTask {
	public static void main(String[] args) {
		Runnable r1 = new DisplayNumber();
		Thread t1 =  new Thread(r1);
		t1.start();
	}
}

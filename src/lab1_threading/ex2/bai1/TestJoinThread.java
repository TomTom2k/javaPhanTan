package lab1_threading.ex2.bai1;

public class TestJoinThread {
	public static void main(String[] args) {
		new Thread(new YourTask()).start();
	}
}

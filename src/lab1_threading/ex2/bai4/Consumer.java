package lab1_threading.ex2.bai4;

public class Consumer implements Runnable {
	MyQueue queue;

	public Consumer(MyQueue queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			queue.getN();
		}
	}
	
}

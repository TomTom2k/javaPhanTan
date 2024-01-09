package lab1_threading.ex2.bai4;

public class Producer implements Runnable {
	MyQueue queue;
	
	public Producer(MyQueue queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		int i= 0;
		while(true) {
			queue.setN(i++);
		}
	}
	
}

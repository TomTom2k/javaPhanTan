package lab1_threading.ex2.bai4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Producer_Consumer_Demo_Fixed {
	public static void main(String[] args) {
		System.out.println("Press Control-C to stop.");
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		MyQueue queue = new MyQueue();
		
		service.execute(new Producer(queue));
		service.execute(new Consumer(queue));
	}
}

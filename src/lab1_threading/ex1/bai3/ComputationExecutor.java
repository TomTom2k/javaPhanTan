package lab1_threading.ex1.bai3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ComputationExecutor {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<Long> call = new ComputationTask("long-last-compution");
		FutureTask<Long> task = new FutureTask<>(call);
		new Thread(task).start();
		
		long result = task.get();
		System.out.println("Result: " + result);
	}
}

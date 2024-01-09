package lab1_threading.ex1.bai3;

import java.util.concurrent.Callable;

public class ComputationTask implements Callable<Long> {
	private String taskName;

	public ComputationTask(String taskName) {
		super();
		this.taskName = taskName;
	}

	@Override
	public Long call() throws Exception {
		Long result = 0L;
		for (int i = 0; i < 100; i++) {
			result += 1;
			System.out.println(taskName + "#" + i);
			Thread.sleep(10);
		}
		return result;
	}

}

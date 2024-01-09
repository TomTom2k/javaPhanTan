package lab1_threading.ex2.bai4;

public class MyQueue {
	int n;
	boolean valueSet = false;

	public synchronized int getN() {
		if (!valueSet) 
			try {wait();} catch (InterruptedException e) {}
		System.out.println("Got: " + n);
		try {Thread.sleep(300);} catch (Exception e) {}

		valueSet = false;
		notify();
		return n;
	}

	public synchronized void setN(int n) {
		if(valueSet)
			try {wait();} catch (Exception e) {}
		this.n = n;
		valueSet = true;
		System.out.println("Put: " + n);
		try {Thread.sleep(500);} catch (Exception e) {}
		notify();
	}

}

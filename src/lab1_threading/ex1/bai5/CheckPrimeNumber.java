package lab1_threading.ex1.bai5;

public class CheckPrimeNumber implements Runnable {
	private int number;

	public CheckPrimeNumber(int number) {
		super();
		this.number = number;
	}

	@Override
	public void run() {
		if (isPrime(number)) {
			System.out.println(number + " is a prime number");
		} else {
			System.out.println(number + " is not a prime number");
		}
	}

	public boolean isPrime(int number) {
		for (int i = 2; i < Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}

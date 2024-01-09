package lab1_threading.ex3.bai1;

public class DepositThread implements Runnable {
	private BankAccount account;

	public DepositThread(BankAccount account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		while(true) {
			account.depositLimited(100);
			try {	
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}

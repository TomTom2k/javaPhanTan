package lab1_threading.ex3.bai1;

public class WithdrawThread implements Runnable {
	private BankAccount account;

    public WithdrawThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            account.withdraw(100);
            try {
                Thread.sleep(300); // Simulate some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

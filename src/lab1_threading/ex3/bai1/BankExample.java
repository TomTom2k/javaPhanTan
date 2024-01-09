package lab1_threading.ex3.bai1;

public class BankExample {
	public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Create deposit and withdraw threads
        Thread depositThread1 = new Thread(new DepositThread(account));
        Thread depositThread2 = new Thread(new DepositThread(account));
        Thread withdrawThread1 = new Thread(new WithdrawThread(account));
        Thread withdrawThread2 = new Thread(new WithdrawThread(account));

        // Start the threads
        depositThread1.start();
        depositThread2.start();
        withdrawThread1.start();
        withdrawThread2.start();
    }
}

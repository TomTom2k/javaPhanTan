package lab1_threading.ex3.bai1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	private int balance = 0;

	public synchronized void deposit(int amount) {
		balance += amount;
		System.out.println("Deposit: " + amount + ", Balance: " + balance);

		notifyAll();
	}

	public synchronized void withdraw(int amount) {
        // Withdrawal logic here
        balance -= amount;
        System.out.println("Withdrawal: " + amount + ", Balance: " + balance);
        notifyAll(); // Notify waiting threads (if any) that a withdrawal has been made
    }
	
	public synchronized void depositLimited(int amount) {
        try {
            // Ensure the deposit does not exceed $100,000
            while ((balance + amount) > 100000) {
                System.out.println("Exceeds deposit limit. Waiting for withdrawal...");
                wait();
            }

            deposit(amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

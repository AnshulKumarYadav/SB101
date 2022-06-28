package unit5.eval1.Question1;

public class Main {
	public static void main(String[] args) {
		DeadLock deadLock = new DeadLock();
		DeadLockB deadLockB = new DeadLockB();
		Thread1 thread1 = new Thread1(deadLock, deadLockB);
		Thread2 thread2 = new Thread2(deadLock, deadLockB);
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		t1.start();
		t2.start();
		}
}

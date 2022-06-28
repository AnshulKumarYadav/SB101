package unit5.eval1.Question1;

public class Thread1 implements Runnable {
	DeadLock d;
	DeadLockB db;
	public Thread1(DeadLock d,DeadLockB db) {
	this.db=db;
	this.d=d;
	}
	@Override
	public void run() {
	d.funA(db);
	}
}

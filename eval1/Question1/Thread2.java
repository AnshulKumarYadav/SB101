package unit5.eval1.Question1;

public class Thread2  implements Runnable{
	DeadLock d;
	DeadLockB db;
	public Thread2(DeadLock d,DeadLockB db) {
	this.d=d;
	this.db=db;
	}
	@Override
	public void run() {
	db.funB(d);
	}
}

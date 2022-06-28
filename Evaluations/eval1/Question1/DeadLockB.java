package unit5.eval1.Question1;

public class DeadLockB {
	public synchronized void funB(DeadLock d){         // solving deadlock by synchronized keyword
		System.out.println("funB of B starts");
		d.fun1();
		System.out.println("funB of B ends");
	}
	public synchronized void fun2(){
		System.out.println("inside fun2 of B");
		}
}

package unit5.eval1.Question1;
//  <<-----------------------------Question--------------------------------------------->>
//Write a program that will result in a deadlock. How will you fix deadlock in Java show with
//examples? And Explain about wait() and notify() method.

// Deadlock:-   If two threads are waiting for each other forever.

//  For fixing deadlock in java we have to declare synchronized keyword 

// wait():-   it releases the lock immediately of that particular object and then it enters into the waiting state immediately.
// notify():- it also releases the lock of that object but not immediately after some time;

public class DeadLock {     //deadlock
	public  void funA(DeadLockB db){
		System.out.println("funA of A starts");
		db.fun2();
		System.out.println("funA of A ends");
		}
		public synchronized void fun1(){
		System.out.println("inside fun1 of A");
		}
}








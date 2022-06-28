package unit5.eval1.Question3;

public class Account {
	int balance;
	int accountNo;
	public void displayBalance() {
		System.out.println("Balance: "+this.balance);
	}
	public void deposit(int amount) {
		System.out.println(amount+" is deposited");
	    System.out.println("Account No:"+this.accountNo);
	    this.balance = this.balance + amount;
	    displayBalance();
	}
	
	public void withdraw(int amount)
	{
		System.out.println(amount +" is withdrawn");
		  System.out.println("Account No:"+this.accountNo);
		  this.balance = this.balance - amount;
		    displayBalance();
	
	}

}
//balance: int;
//accountNo: int;
//displayBalance():void;
//deposit(int amount):void;
//withdraw(int amount):void;
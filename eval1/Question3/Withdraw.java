package unit5.eval1.Question3;

public class Withdraw  implements Runnable{
	
	int amount;
	Account account;
	
	public Withdraw() {
		// TODO Auto-generated constructor stub
	}
	
	public Withdraw(int amount, Account account) {
		super();
		this.amount = amount;
		this.account = account;
	}

	@Override
	public void run() {
	    account.withdraw(amount);
	}

}

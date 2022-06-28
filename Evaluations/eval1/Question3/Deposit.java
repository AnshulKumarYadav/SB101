package unit5.eval1.Question3;

public class Deposit implements Runnable {

	int amount;
	Account account;
	public Deposit() {
		// TODO Auto-generated constructor stub
	}
	public Deposit(int amount, Account account) {
		super();
		this.amount = amount;
		this.account = account;
	}

	@Override
	public void run() {
	    account.deposit(amount);
	}
}

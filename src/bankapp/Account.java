package bankapp;

public abstract class Account implements IBaseRate{
	// Common properties for Chequing and Savings accounts:
	private String name;
	private String sIN;
	private double balance;
	private static int index = 10000;
	
	protected String accountNumber;
	protected double rate;
	
	// Constructor to set base properties and initialize the account:
	public Account(String name, String sIN, double initDeposit) {
		this.name = name;
		this.sIN = sIN;
		balance = initDeposit;		
		index++;
		this.accountNumber = setAccountNumber();
		setRate();
	}
	
	public abstract void setRate();
	
	private String setAccountNumber() {
		String lastTwoOfSIN = sIN.substring(sIN.length() - 2, sIN.length());
		int uniqueID = index;
		String randomNumber = randomNumber(3);
		return lastTwoOfSIN + uniqueID + randomNumber;
	}
	
	public void compound() {
		double accruedInterest = balance * (rate / 100);
		balance += accruedInterest;
		System.out.println("Accrued Interest: $" + accruedInterest);
		printBalance();
	}
	
	public String randomNumber(int digits) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < digits; i++) {
			sb.append((int)(Math.random() * 10));
		}
		return sb.toString();
	}
	
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance -= amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance -= amount;
		System.out.println("Transfering $" + amount + " to " + toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is now: $" + balance);
	}
	
	public void showInfo() {
		System.out.println(
				"NAME: " + name + "\n" + 
				"ACCOUNT NUMBER: " + accountNumber + "\n" + 
				"BALANCE: " + balance + "\n" +
				"RATE: " + rate + "%"
				);
	}
}

package bankapp;

public class Savings extends Account {
	// Properties specific to a Savings account:
	private String safetyDepositBoxID;
	private String safetyDepositBoxKey;
	
	public Savings(String name, String sIN, double initDeposit) {
		super(name, sIN, initDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() - 0.25;
	}
	
	private void setSafetyDepositBox() {
		safetyDepositBoxID = randomNumber(3);
		safetyDepositBoxKey = randomNumber(4);
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println(
				" Your Savings Account Features " + "\n" + 
				" Safety Deposit Box ID: " + safetyDepositBoxID + "\n" + 
				" Safety Deposit Box Key: " + safetyDepositBoxKey
				);
	}
}

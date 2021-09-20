package bankapp;

public class Chequing extends Account {
	// Properties specific to a Chequing account:
	private String debitCardNumber;
	private String debitCardPIN;
	
	public Chequing(String name, String sIN, double initDeposit) {
		super(name, sIN, initDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() * 0.15;
	}

	private void setDebitCard() {
		debitCardNumber = randomNumber(12);
		debitCardPIN = randomNumber(4);
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println(
				" Your Chequing Account Features" + "\n" +
				" Debit Card Nuber: " + debitCardNumber + "\n" +
				" Debit Card PIN: " + debitCardPIN
				);
	}
}

package bankapp;

import java.util.ArrayList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		List<Account> accounts = new ArrayList<>();
		
		// Read a CSV file then create new accounts based on that data
		String file = "C:\\BankAccountApp\\Files\\NewBankAccounts.csv";
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for (String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String sIN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			if (accountType.equals("Chequing")) {
				accounts.add(new Chequing(name, sIN, initDeposit));
			} else if (accountType.equals("Savings")) {
				accounts.add(new Savings(name, sIN, initDeposit));
			} else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		for (Account account : accounts) {
			account.showInfo();
			System.out.println("*******************************");
		}
	}
}

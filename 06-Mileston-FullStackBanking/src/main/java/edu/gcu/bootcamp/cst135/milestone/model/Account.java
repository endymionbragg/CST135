package edu.gcu.bootcamp.cst135.milestone.model;

// Parent class for dependent classes
public abstract class Account {

	private String accountNumber;
	private double accountBalance;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String toString() {
		return accountNumber + " $" + accountBalance;
	}

	// Constructor for Accounts
	public Account(String accountNumber, double accountBalance) {

		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}	
}

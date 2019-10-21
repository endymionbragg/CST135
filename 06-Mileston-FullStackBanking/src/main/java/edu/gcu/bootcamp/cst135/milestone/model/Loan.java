package edu.gcu.bootcamp.cst135.milestone.model;

public class Loan extends Account{
	
	private double interestRate;
	private double lateFee;
	
	// Getters and Setters for Loan Account
	public Loan (String accountNumber, double accountBalance) {
		super(accountNumber, accountBalance);

	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}
	
	public void doEndofMonthInterest() {
		return;
		
	}
	
	public void checkLateFee() {
		return;
	}


}

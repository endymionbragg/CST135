package edu.gcu.bootcamp.cst135.milestone.model;

public class Saving extends Account {

	private double minBalance;
	private double interest;
	private double serviceFee;
	
	/**
	 * Gets minBalance assigned to customer an returns value
	 * @return minBalance
	 */
	public double getMinBalance() {
		return minBalance;
	}

	/**
	 * Sets the min balance for savings
	 * @param minBalance 
	 */
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	/**
	 * Gets interest assigned to customer as passed through
	 * @return
	 */
	public double getInterest() {
		return interest;
	}

	/**
	 * Sets the interest rate for savings
	 * @param interest
	 */
	public void setInterest(double interest) {
		this.interest = interest/12;
	}

	/**
	 * Get the service fee and returns value
	 * @return serviceFee
	 */
	public double getServiceFee() {
		return serviceFee;
	}

	/**
	 * Set serviceFee for the customer
	 * @param serviceFee
	 */
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}

	/**
	 * 
	 * Initialize variables that make up the Saving constructor
	 * 
	 * @param accountNumber
	 * @param balance
	 * @param minBalance
	 * @param serviceFee
	 * @param interest
	 */
	public Saving(String accountNumber, double balance, double minBalance, double serviceFee , double interest) {
		
		super(accountNumber, balance);
		this.minBalance = minBalance;
		this.serviceFee = serviceFee;
		this.interest = interest/12;		
	}
}
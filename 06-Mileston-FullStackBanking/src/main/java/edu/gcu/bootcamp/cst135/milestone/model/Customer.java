package edu.gcu.bootcamp.cst135.milestone.model;


public class Customer {

	String firstName;
	String lastName;
	String username;
	String password; 
	
	Saving savings = new Saving("-SAV12345",500,200,25,.06);
	Checking checking = new Checking("-CHK23456",2500,25);
	Loan loan = new Loan("-LOAN7890",-5000);
	
	/**
	 * 
	 * Initialize the first and last name, username and password
	 * 
	 * @param firstName 
	 * @param lastName
	 * @param username
	 * @param password
	 */
	public Customer(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	
	}
	
	
	
	// Getters and Setters for Customer Class
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Saving getSavings() {
		return savings;
	}

	public void setSavings(Saving savings) {
		this.savings = savings;
	}


	public Checking getChecking() {
		return checking;
	}


	public void setChecking(Checking checking) {
		this.checking = checking;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	
	@Override
	public String toString() {
		return firstName + lastName;
	}

	
}
package edu.gcu.bootcamp.cst135.milestone.controller;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.ArrayList;
import edu.gcu.bootcamp.cst135.milestone.FullStackBanking.Transaction;
import edu.gcu.bootcamp.cst135.milestone.model.Customer;

public class Bank {
	
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private ArrayList<Transaction> accountTransactions = new ArrayList<Transaction>();
	
	// Create scanner object for user input
	Scanner scanner = new Scanner(System.in);	
	
	// Creating a new customer object and passing parameters
	Customer customer = new Customer ("LeRoy ", "Green", "LastDragon1985", "IamtheMaster!85");
	
	// Customer login screen. The first screen users will see
	public void viewCustomerScreen () {
		int loginChoice = 0;
		do {
			System.out.println("\n====================\n");
			System.out.println("\n    MAIN MENU   \n");
			System.out.println("\n====================\n");
			System.out.println(" 1: Log-in");
			System.out.println(" 9: Exit Bank");
			loginChoice = getLoginChoice();
			processLogInMenu(loginChoice);
		} while (loginChoice != 9);
			
	}
	
	// Exit screen for the program
	private void viewExitScreen() {
		System.out.println("Goodbye, Have a good day " + customer.toString() + "!");
		System.exit(0);
	}
	
	// Customer menu options once logged in with valid username and password
	
	/**
	 * 
	 * Display Main Menu options for the customer to navigate account
	 * 
	 */
	public void viewCustomerMenu() {
		
			int choice = 0;
			do {
				System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("                MAIN MENU");
				System.out.println("                GCU BANK");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("Pick an option: ");
				System.out.println("-----------------------");
				System.out.println(" 1: Deposit to Checking");
				System.out.println(" 2: Deposit to Savings");
				System.out.println(" 3: Withdraw from Checking");
				System.out.println(" 4: Withdraw from Savings");			
				System.out.println(" 5: Get balance");
				System.out.println(" 6: Get monthly statement");
				System.out.println(" 7: View your transactions");
				System.out.println("------------------------");
				System.out.println(" 9: : Logout");
				choice = getUserMenuChoice();
				processCustomerMenu(choice);
			} while (choice != 9);
			
	}	
	
	// Switch statement for logging in from viewCustomerScreen
	private void processLogInMenu (int parseInt) {
		switch(parseInt) {
		case 1: 
			logger.info("I am Logging On");
			viewLogInScreen();
		break;
		case 9:
			logger.info("I am Logging off");
			viewExitScreen();
		break;
		default: viewCustomerScreen();
		}
	}
	
	// Processing the Main Menu options for the account
	private void processCustomerMenu(int parseInt) {
		

		switch(parseInt) {
		case 1: 
			logger.info("I am depositing into Checking");
			viewDepositChecking();
			viewBalances();
		break;
		case 2:
			logger.info("I am depositing into Savings");
			viewDepositSavings();
			viewBalances();
		break;
		case 3:
			logger.info("Withdraw into Checking");
			viewWithdrawalChecking();
			viewBalances();
		break;
		case 4:
			logger.info("Withdraw into Savings");
			viewWithdrawalSavings();
			viewBalances();
		break;
		case 5:
			logger.info("Getting the Balance");
			viewBalances();
		break;
		case 6:
			logger.info("Viewing End of Month");
			viewEndOfMonth();
			viewBalances();
			displayTransactions();
		break;  
		case 7:
			logger.info("Viewing Transactions");
			displayTransactions();
		break;  
		case 9:
			logger.info("I am Logging off");
			viewExitScreen();
		break;
		default: viewCustomerMenu();
		}
	}
	
	// Method for login screen verification and validation 
	private void viewLogInScreen() {
		System.out.println("\n====================\n");
		System.out.println("          LOG-IN          ");
		System.out.println("\n====================\n");
		System.out.println("Enter User Name: ");
		String enterName = scanner.nextLine();
		System.out.println("Enter Your Password: ");
		String enterPassword = scanner.nextLine();	
		
		if (customer.getUsername().equalsIgnoreCase(enterName) && customer.getPassword().equals(enterPassword)) {
			System.out.println("Welcome " + customer.toString());
			viewCustomerMenu();
			
		} else
			System.out.println("Wrong User Name and/or Password. Try again");
		viewLogInScreen();
	}

	// End of month: will display month ends balance interest and transactions
	private void viewEndOfMonth() {
        System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("               END OF MONTH");
        System.out.println("                 GCU BANK");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
        if (customer.getSavings().getAccountBalance() < customer.getSavings().getMinBalance()) {
            System.out.printf("A $%.2f service fee is being assessed for below minimum balance in savings",
            		customer.getSavings().getServiceFee());
            customer.getSavings().setAccountBalance(customer.getSavings().getAccountBalance() - customer.getSavings().getServiceFee());
            addTransaction(new Transaction(customer.getSavings().getAccountNumber(), customer.getSavings().getServiceFee(),"Service Fee"));
        }
        if (customer.getSavings().getAccountBalance() > 0) {
            double interestAmount = (customer.getSavings().getInterest() * customer.getSavings().getAccountBalance());
            customer.getSavings().setAccountBalance(customer.getSavings().getAccountBalance() + interestAmount);
            }
        	displayTransactions();
    }			

	// Method for transaction array, will store deposit and withdrawl information
	private void displayTransactions() {
		System.out.println("\n-----SESSION TRANSACTION---------");
		
		for(int i = 0; i < accountTransactions.size(); i++) {
			System.out.println(accountTransactions.get(i));
		}
		
		System.out.println("\n-------------------------------");
	}
	
	private void addTransaction(Transaction tran) {
		accountTransactions.add(tran);
	}

	// Prompt for checking withdraw 
	private void viewWithdrawalChecking() {

			System.out.println("How much would you like to withdraw: ");
			double input = getUserAmount();
			processWithdrawalChecking(input);
		
	}

	// Method to process checking withdraw. Will deduct input amount from overall total
	// Will alert customer of overdraft fee if withdraw is greater than balance
	private void processWithdrawalChecking(double input) {

		if(customer.getChecking().getAccountBalance() < input) {
			System.out.println("A $" + customer.getChecking().getOverdraft() + " overdraft fee will be assessed if you continue. Continue Y or N?");
			if(scanner.nextLine().toLowerCase().equals("y")) {
				customer.getChecking().setAccountBalance(customer.getChecking().getAccountBalance() - input - customer.getChecking().getOverdraft());
				addTransaction(new Transaction(customer.getChecking().getAccountNumber(), input, "Withdraw"));
			}else
				viewWithdrawalChecking();
		}else {
			customer.getChecking().setAccountBalance(customer.getChecking().getAccountBalance() - input);
			addTransaction(new Transaction(customer.getChecking().getAccountNumber(), input, "Withdraw"));

		}
		
	}

	// Prompt for Savings deposit 
	private void viewDepositSavings() {

			System.out.println("How much would you like to deposit: ");
			double input = getUserAmount();
			processDepositSavings(input);

	}
	// Method to process savings deposit. Will add input amount to overall account total
	private void processDepositSavings(double input) {

		customer.getSavings().setAccountBalance(customer.getSavings().getAccountBalance() + input);
		addTransaction(new Transaction(customer.getSavings().getAccountNumber(), input, "Deposit"));

	}
	
	// Prompt for checking deposit
	private void viewDepositChecking() {

			System.out.println("How much would you like to deposit: ");
			double input = getUserAmount();
			processDepositChecking(input);

	}

	// Method to process checking deposit. Will add input amount to overall account total
	private void processDepositChecking(double input) {

		customer.getChecking().setAccountBalance(customer.getChecking().getAccountBalance() + input);
		addTransaction(new Transaction(customer.getChecking().getAccountNumber(), input, "Deposit"));

	}

	// Prompt for savings withdraw
	private void viewWithdrawalSavings() {

			System.out.println("How much would you like to withdraw: ");
			double input = getUserAmount();
			processWithdrawalSavings(input);
				
	}

	// Method to process checking withdraw. Will deduct input amount from overall total
	private void processWithdrawalSavings(double input) {

		customer.getSavings().setAccountBalance(customer.getSavings().getAccountBalance() - input);
		addTransaction(new Transaction(customer.getSavings().getAccountNumber(), input, "Withdraw"));

	}

	// Display total balance of all three accounts
	private void viewBalances() {

		System.out.println("\n------------------------\n");	
		System.out.println(customer.getSavings().toString());
		System.out.println(customer.getChecking().toString());
		System.out.println(customer.getLoan().toString());
		
		System.out.println("\n------------------------\n");
	}
	
	// Method to process login choice, will check for valid input
	private int getLoginChoice() {
		boolean success = false;
        int result = 0;
        while (!success) {
            String loginOption = scanner.nextLine();
            success = true;
            try {
                result = Integer.parseInt(loginOption);
            }
            catch (NumberFormatException e) {
                System.out.println("Expecting a numeric menu choice.  Please try again.");
                success = false;                
            }
        }
        return result;
    }
	
	// Will process user menu choice and check for valid input
	private int getUserMenuChoice() {
		boolean success = false;
        int result = 0;
        while (!success) {
            String option = scanner.nextLine();
            success = true;
            try {
                result = Integer.parseInt(option);
            }
            catch (NumberFormatException e) {
                System.out.println("Expecting a numeric menu choice.  Please try again.");
                success = false;                
            }
        }
        return result;
    }
	
	// Taking input for deposit and withdraw amount to process, will only accept numeric values.
	private double getUserAmount() {
		boolean success = false;
        double result = 0;
        while (!success) {
            String option = scanner.nextLine();
            success = true;
            try {
               result = Double.parseDouble(option);
            }
            catch (NumberFormatException e) {
                System.out.println("Expecting a numeric menu choice.  Please try again.");
                success = false;                
            }
        }
        return result;
		
	}
}
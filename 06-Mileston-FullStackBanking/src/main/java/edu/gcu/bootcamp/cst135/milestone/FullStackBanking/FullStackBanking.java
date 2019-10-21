package edu.gcu.bootcamp.cst135.milestone.FullStackBanking;

import edu.gcu.bootcamp.cst135.milestone.controller.Bank;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;


public class FullStackBanking {

	// Start of program
	public static void main(String[] args) {
		
		
		final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

		try
		{
			try
			{
				MyLogger.setup();
			} 
			catch (IOException e) // Catching IOExeption 
			{
				e.printStackTrace(); // Printing error to track and log
			}
			Bank bank = new Bank();
			bank.viewCustomerScreen();
		}
		catch (Exception e) {
			StringWriter sw = new StringWriter(); // Turns exception into a string
			PrintWriter pw = new PrintWriter(sw); // Prints string 
			e.printStackTrace(pw);
			logger.severe(sw.toString());
		}

		
	}
}
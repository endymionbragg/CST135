package edu.gcu.bootcamp.cst135.milestone.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckingTest {

	@Test
	public void testGetOverdraft() {
		final double overDraft = 50.40;
		Checking checking = new Checking("Test",0, overDraft);
		
		assertEquals("Overdraft test fails", checking.getOverdraft(), overDraft, 0.001);
		
	}

//	@Test
//	public void testSetOverdraft() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAccountNumber() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetAccountNumber() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testGetAccountBalance() {
		final double accountBalance = 510.0;
		Checking checking = new Checking("Test", accountBalance, 25);
		assertEquals("Account Balance test fails", checking.getAccountBalance(), accountBalance, 0.001);
	}
//
//	@Test
//	public void testSetAccountBalance() {
//		fail("Not yet implemented");
//	}

}

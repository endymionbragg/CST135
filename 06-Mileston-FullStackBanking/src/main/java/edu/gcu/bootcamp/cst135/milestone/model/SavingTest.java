package edu.gcu.bootcamp.cst135.milestone.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SavingTest {

//	@Test
//	public void testGetMinBalance() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetMinBalance() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetInterest() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetInterest() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetServiceFee() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetServiceFee() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSaving() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAccountNumber() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testSetAccountNumber() {
		final String accountNum = "SAV09033";
		Saving savings = new Saving(accountNum, 0, 0, 0,.06);
		assertEquals("Account Number test fails", savings.getAccountNumber(), accountNum);
	}

	@Test
	public void testGetAccountBalance() {
		final double accountBalance = 750.0;
		Saving savings = new Saving("Test", accountBalance, 25, 25, .06);
		assertEquals("Account Balance test fails", savings.getAccountBalance(), accountBalance, 0.001);
	}

//	@Test
//	public void testSetAccountBalance() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testToString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAccount() {
//		fail("Not yet implemented");
//	}

}

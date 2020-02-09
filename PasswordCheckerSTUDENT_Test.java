
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> pwdArray;
	String password1, password2;
	
	@Before
	public void setUp() throws Exception {
		String[] p = {"22WW22WW22", "lETsg0n0W", "Kw3si000", "Yes1", "43amina", "5rFse2Vc9",
				"January01", "okL017", "pearSryryry", "vB77Bv"};
		pwdArray = new ArrayList<String>();	
		pwdArray.addAll(Arrays.asList(p));
	}
	
	@After
	public void tearDown() throws Exception {
	
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValid("crmFRA01"));
			PasswordCheckerUtility.isValid("wre94");
			assertTrue("Did not throw LengthException", false);
		}
		catch(LengthException e){
			assertTrue("Threw LengthExcepetion", true);
		}
		catch(Exception e){
			assertTrue("Threw other exception than LengthException", false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValid("sqW2178"));
			PasswordCheckerUtility.isValid("ife2e43");
			assertTrue("Did not throw NoUpperAlphaException", false);
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Threw NoUpperAlphaException", true);
		}
		catch(Exception e) {
			assertTrue("Threw other exception than NoUpperAlphaException", false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValid("dxzQP03"));
			PasswordCheckerUtility.isValid("DKGNE32O5");
			assertTrue("Did not throw NoLowerAlphaException", false);
		}
		catch(NoLowerAlphaException e) {
			assertTrue("Thew NoLowerAlphaException", true);
		}
		catch(Exception e) {
			assertTrue("Threw other exception than NoLowerAlphaException", false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValid("5dt7eFeS7"));
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("4LkiJ8");
			assertTrue(weakPwd);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw wrong exception", false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValid("ds3RdWKp0"));
			PasswordCheckerUtility.isValid("ewE333sDfv");
			assertTrue("Did not throw InvalidSequenceException", false);
		}
		catch(InvalidSequenceException e) {
			assertTrue("Threw InvalidSequenceException", true);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw other exception than InvalidSequenceException", false);
		}
	}
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValid("evkBV43a"));
			PasswordCheckerUtility.isValid("IeQxTKvms");
			assertTrue("Did not throw NoDigitException", false);
		}
		catch(NoDigitException e) {
			assertTrue("Threw NoDigitException", true);
		}
		catch(Exception e) {
			assertTrue("Threw other exception than NoDigitException", false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 * @throws Exception 
	 */
	@Test
	public void testIsValidPasswordSuccessful() throws Exception
	{
			assertTrue(PasswordCheckerUtility.isValid("gT37c1BmxK"));
	}
	
	/**
	 * Test the validPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 * @throws Exception 
	 */
	@Test
	public void testValidPasswords() throws Exception {
		ArrayList<String> results;
		results = PasswordCheckerUtility.invalidPasswords(pwdArray);
		Scanner scan = new Scanner(results.get(0)); //
		assertEquals(scan.next(), "22WW22WW22");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		//assertEquals(scan.nextLine(), " The password must contain at least one lowercase alphabetic character.");
		scan = new Scanner(results.get(1)); //
		assertEquals(scan.next(), "Kw3si000");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("more than two"));
		//assertEquals(scan.nextLine(), " The password cannot contain more than two of the same character in sequence.");
		scan = new Scanner(results.get(2)); //
		assertEquals(scan.next(), "Yes1");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("at least"));
		//assertEquals(scan.nextLine(), " The password must contain at least 6 alphanumeric characters.");
		scan = new Scanner(results.get(3)); //
		assertEquals(scan.next(), "43amina");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		//assertEquals(scan.nextLine(), " The password must contain at least one uppercase alphabetic character.");
		scan = new Scanner(results.get(4)); //a
		assertEquals(scan.next(), "pearSryryry");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
		//assertEquals(scan.nextLine(), " The password must contain at least one digit.");
	}
	
}

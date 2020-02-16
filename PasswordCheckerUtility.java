
import java.util.ArrayList;
/**
 * This class tests the validity of passwords
 * @author Matthew Quander
 *
 */

public class PasswordCheckerUtility {
	/**
	 * No-arg constructor
	 */
	public PasswordCheckerUtility(){
	}
	/**
	 * Method to test password length, test if it has an uppercase, lowercase, and a digit, 
	 * test if it has more than 3 characters in a sequence. Throws exceptions if so.
	 * @param pwdString Password string passed to method to test
	 * @return Returns true if password is valid
	 * @throws Exception Throws particular exception if password is invalid
	 */
	static boolean isValid(String pwdString) throws Exception{
		if(pwdString.length() < 6) {
			throw new LengthException();
		}
		int digits = 0, upperCase = 0, lowerCase = 0, triples = 0;
		for(int i = 0; i < pwdString.length(); i++) {
			if(Character.isDigit(pwdString.charAt(i)))
				digits++;
			if(Character.isUpperCase(pwdString.charAt(i)))
				upperCase++;
			if(Character.isLowerCase(pwdString.charAt(i)))
				lowerCase++;
		}
		for(int i = 0; i < pwdString.length()-2; i++) {
			if((pwdString.charAt(i) == pwdString.charAt(i+1)) && (pwdString.charAt(i+1) == pwdString.charAt(i+2)))
				triples++;
		}		
		if(upperCase == 0) {
			throw new NoUpperAlphaException();
		}
		if(lowerCase == 0) {
			throw new NoLowerAlphaException();
		}
		if(digits == 0) {
			throw new NoDigitException();
		}
		if(triples > 0) {
			throw new InvalidSequenceException();
		}
		return true;
	}
	/**
	 * Method to test if the password is weak, between 6 and 9 characters long
	 * @param pwdString Password string passed to the method
	 * @return Returns true or false whether password is weak
	 */
	static boolean isWeakPassword(String pwdString) {
		if(pwdString.length() >= 6 && pwdString.length() <= 9)
			return true;
		else
			return false;
	}
	/**
	 * Method to test for invalid passwords in an array list of strings
	 * @param passwords Array list of strings passed to method
	 * @return Returns a new array list of only invalid passwords
	 * @throws Exception Captures message from exception throw of invalid password 
	 */
	static ArrayList<String> invalidPasswords(ArrayList<String> passwords) throws Exception{
		
		ArrayList<String> inputList = new ArrayList<>();
		for(int i = 0; i < passwords.size(); i++) {
			try {
				if(!isValid(passwords.get(i))) {}
				
			}catch(Exception e) {
				inputList.add(passwords.get(i) +" "+ e.getMessage());
			}
		}
		return inputList;
	}
}

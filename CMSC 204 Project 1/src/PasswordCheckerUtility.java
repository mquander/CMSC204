
import java.util.ArrayList;
/**
 * This class tests the validity of passwords
 * @author 
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
	static boolean isValidPassword(String pwdString) throws Exception{
		if(pwdString.length() < 6) {
			throw new LengthException();
		}

		if(!hasUpperCase(pwdString)) {
			throw new NoUpperAlphaException();
		}
		if(!hasLowerCase(pwdString)) {
			throw new NoLowerAlphaException();
		}
		if(!hasDigits(pwdString)) {
			throw new NoDigitException();
		}
		if(hasTriples(pwdString)) {
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
		boolean returnValue;
		
		if(pwdString.length() >= 6 && pwdString.length() <= 9)
			returnValue = true;
		else
			returnValue = false;
		
		return returnValue;
	}
	/**
	 * Method to test for invalid passwords in an array list of strings
	 * @param passwords Array list of strings passed to method
	 * @return Returns a new array list of only invalid passwords
	 * @throws Exception Captures message from exception throw of invalid password 
	 */
	static ArrayList<String> invalidPasswords(ArrayList<String> passwords){
		
		ArrayList<String> inputList = new ArrayList<>();
		
		for(int i = 0; i < passwords.size(); i++) {
			try {
				if(!isValidPassword(passwords.get(i))) {}
				
			}catch(Exception e) {
				inputList.add(passwords.get(i) +" "+ e.getMessage());
			}
		}
		return inputList;
	}
	/**
	 * Private method to check if password has digits
	 * @param pwdString password string
	 * @return true or false
	 */
	private static boolean hasDigits(String pwdString) {
		boolean returnValue = false;
		
		for(int i = 0; i < pwdString.length(); i++) {
			if(Character.isDigit(pwdString.charAt(i))) {
				returnValue = true;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * Private method to check if password has upper case
	 * @param pwdString password string
	 * @return true or false
	 */
	private static boolean hasUpperCase(String pwdString) {
		boolean returnValue = false;
		
		for(int i = 0; i < pwdString.length(); i++) {
			if(Character.isUpperCase(pwdString.charAt(i))) {
				returnValue = true;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * Private method to check if method has lower case
	 * @param pwdString password string
	 * @return true or false
	 */
	private static boolean hasLowerCase(String pwdString) {
		boolean returnValue = false;
		
		for(int i = 0; i < pwdString.length(); i++) {			
			if(Character.isLowerCase(pwdString.charAt(i))) {
				returnValue = true;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * Private method to check if password has 3 consecutive repeating characters
	 * @param pwdString password string
	 * @return true or false
	 */
	private static boolean hasTriples(String pwdString) {
		boolean returnValue = false;
		
		for(int i = 0; i < pwdString.length()-2; i++) {
			if((pwdString.charAt(i) == pwdString.charAt(i+1)) && (pwdString.charAt(i+1) == pwdString.charAt(i+2))) {
				returnValue = true;
				break;
			}
		}	
		return returnValue;
	}
}

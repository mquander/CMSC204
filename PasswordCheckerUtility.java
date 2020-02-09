import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.stage.FileChooser;

public class PasswordCheckerUtility {
	
	public PasswordCheckerUtility(){
		// no-arg constructor method
	}
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
		if(digits == 0) {
			throw new NoDigitException();
		}
		if(upperCase == 0) {
			throw new NoUpperAlphaException();
		}
		if(lowerCase == 0) {
			throw new NoLowerAlphaException();
		}
		if(triples > 0) {
			throw new InvalidSequenceException();
		}
		
		return true;
	}
	static boolean isWeakPassword(String pwdString) {
		if(pwdString.length() >= 6 && pwdString.length() <= 9)
			return true;
		else
			return false;
	}
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

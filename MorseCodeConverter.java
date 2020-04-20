import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class to read in and convert a Morse Code String or file
 * @author Matt Quander
 *
 */
public class MorseCodeConverter {
	/**
	 * Static reference variable for MorseCodeTree
	 */
	private static MorseCodeTree mct = new MorseCodeTree();
	
	/**
	 * Method to convert Morse Code in a file to English
	 * @param codeFile - File to read in
	 * @return a String of English text
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		String strToReturn = "";
		String strToRead = "";
		
		Scanner scan = new Scanner(codeFile);
		while(scan.hasNextLine())
			strToRead += scan.nextLine();
		scan.close();
		
		strToReturn = convertToEnglish(strToRead);
		return 	strToReturn;
	}
	/**
	 * Method to convert Morse Code into English
	 * @param code - String of Morse Code to convert
	 * @return English translation
	 */
	public static String convertToEnglish(String code) {
		String strToReturn = "";
		String words[] = code.split(" / ");
		String chars[];

		for(int i = 0; i < words.length; i++) {
			chars = words[i].split(" ");
			for(int j = 0; j < chars.length; j++) 
				strToReturn += mct.fetch(chars[j]);
			strToReturn += " ";
		}
		
		return strToReturn.trim();
	}
	/**
	 * Method to display the tree nodes stored in the array list
	 * @return String of English conversion
	 */
	public static String printTree() {
		ArrayList<String> tree = new ArrayList<>();
		tree = mct.toArrayList();
		String str = "";
		for(int i = 0; i < tree.size(); i++) 
			str += tree.get(i) + " ";
		return str;
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class to manager data structure
 * @author Matt Quander
 *
 */
public class ConcordanceDataManager implements ConcordanceDataManagerInterface{
	/**
	 * Field to store ConcordanceDataStructure object
	 */
	private ConcordanceDataStructure cds;
	/**
	 * Method to create array list of the Concordance
	 * @param input - String of text to process
	 * @return array - array list of data structure
	 */
	@Override
	public ArrayList<String> createConcordanceArray(String input) {
		cds = new ConcordanceDataStructure(700);
		ArrayList<String> array = new ArrayList<>();
		String parsedString ; 
		//input = input.replaceAll("(?m)^[ \t]*\r?\n", ""); // delete blank lines
		//input = input.replaceAll("(?m)^\\s+$", ""); // delete blank lines
		String [] tokenLines = input.split("\n");  // split line into String array
		String [] tokenWords;
		
		for(int i = 0; i < tokenLines.length; i++) {
			tokenWords = tokenLines[i].split(" ");
			
			for(int j = 0; j < tokenWords.length; j++) {
				parsedString = parseString(tokenWords[j]);
				if(validateString(parsedString)) 
					cds.add((parsedString), i + 1);
			}
		}

		array = cds.showAll();
		
		return array;
	}
	/**
	 * Method to read in file and output a concordance file
	 * @param input - file to read
	 * @param output - file to write to
	 * @return true if wrote to file successfully
	 * @throws FileNotFoundException if file not found
	 */
	@Override
	public boolean createConcordanceFile(File input, File output) throws FileNotFoundException {
				
		String textFromFile = "";
		ArrayList<String> concordanceArray;
		
		try {
			if(!input.canRead())
				throw new IOException();
		} catch (IOException e1) {
				e1.getMessage();
		}
		Scanner scan = new Scanner(input);
		
		while(scan.hasNext()) {
			textFromFile += scan.nextLine() + "\n";
		}
		concordanceArray = createConcordanceArray(textFromFile);
		
		scan.close();
		try {
			FileWriter outputFile = new FileWriter(output);
			for(int i = 0; i < concordanceArray.size(); i++)
				outputFile.write(concordanceArray.get(i));
			
			outputFile.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Private method to parse out punctuation
	 * @param input - String word to parse
	 * @return input - parsed String
	 */
	private String parseString(String input) {
			
			input = input.replaceAll("[!?.,:;\"]", "");
			input = input.replaceAll("^\"+|\"+$", "");
			input = input.replace("_", "");
			input = input.toLowerCase();
	
		return input;
	}
	/**
	 * Private method to validate String for concordance
	 * @param input - String word to validate
	 * @return true if word is valid, false if not
	 */
	private boolean validateString(String input) {
		
		if(input.length() >= 3 && (!input.equals("and") && !input.equals("the"))) 
			return true;
		else
			return false;
			
	}
	/**
	 * Private inner class to throw when file cannot be read
	 * @author Matt Quander
	 *
	 */
	@SuppressWarnings("serial")
	private class IOException extends Exception{
		
		public IOException() {
			super("File can foundIO");
		}
	}
	
}

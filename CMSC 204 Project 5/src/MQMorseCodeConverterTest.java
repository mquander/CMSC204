import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Class to test MorseCodeConverter class methods
 * @author
 *
 */
class MQMorseCodeConverterTest {
	File inputFile;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	/**
	 * Test converting Morse Code string to English
	 */
	@Test
	void testConvertToEnglishString() {
		String testString = "--. --- --- -.. / -- --- .-. -. .. -. --.";
		String convertedString = MorseCodeConverter.convertToEnglish(testString);
		assertEquals(convertedString, "good morning");
		
		testString = ".... .- ...- . / ... --- -- . / -.-. --- ..-. ..-. . .";
		convertedString = MorseCodeConverter.convertToEnglish(testString);
		assertEquals(convertedString, "have some coffee");
	}
	/**
	 * Test converting Morse Code file to English
	 * @throws FileNotFoundException
	 */
	@Test
	void testConvertToEnglishFile() throws FileNotFoundException {
		String testString = "testing this code"; 
		getFile("MQ_MorseCodeTest.txt");
		String converted = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(testString, converted);
		
		testString = "welcome to java";
		getFile("MQ_MorseCodeTest2.txt");
		converted = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(testString, converted);
	}
	/**
	 * Private method to get the file
	 * @param in
	 * @throws FileNotFoundException
	 */
	private void getFile(String in) throws FileNotFoundException {		
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select File: " + in);
		status = chooser.showOpenDialog(null);

		if(status == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inputFile = chooser.getSelectedFile();
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Problem with  file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}

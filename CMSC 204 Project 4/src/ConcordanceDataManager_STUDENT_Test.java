import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * JUnit test class for the CondordanceDataManager class
 * @author 
 *
 */
public class ConcordanceDataManager_STUDENT_Test {

	private ConcordanceDataManager cdm;
	private File input, output;
	private String text;

	/**
	 * Create an instance of ConcordanceDataManager
	 * Create a string for testing
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		cdm = new ConcordanceDataManager();
		text = "The time is always\nright to do\n" + 
				"what is right.";
	}

	/**
	 * Set cdm to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		cdm = null;
	}

	/**
	 * Test createConcordanceArray method
	 * Use String text created in setUp()
	 */
	@Test
	public void testCreateConcordanceArray() {
		ArrayList<String> words = cdm.createConcordanceArray(text);
		assertEquals(words.get(0),"always: 1\n");
		assertEquals(words.get(1), "right: 2, 3\n");
		assertEquals(words.get(2),"time: 1\n");
		assertEquals(words.get(3),"what: 3\n");
		
	}
	
	
	/**
	 * Test createConcordanceFile method
	 * Create an input "TestA.txt" 
	 * and an output "TestOutA.txt"
	 */
	@Test
	public void testCreateConcordanceFileA() {
		ArrayList<String> words = new ArrayList<String>();
		try {
			input = new File("TestA.txt");
			PrintWriter inFile = new PrintWriter(input);
			inFile.print("The time is always\nright to do\n"
						+"what is right.");
			
			inFile.close();
			output = new File("TestOutA.txt");
			PrintWriter outFile = new PrintWriter(output);
			outFile.print(" ");
			
			cdm.createConcordanceFile(input, output);
			Scanner scan = new Scanner(output);
			while (scan.hasNext())
			{
				words.add(scan.nextLine());
			}

			scan.close();
			outFile.close();
		 
			assertEquals(words.get(0),"always: 1");
			assertEquals(words.get(1), "right: 2, 3");
			assertEquals(words.get(2),"time: 1");
			assertEquals(words.get(3),"what: 3");
			
		} catch (FileNotFoundException e) {
			
			fail("This should not have caused an FileNotFoundException");
		} catch (Exception e) {
			
			fail("This should not have caused an Exception");
		}
	}

	/**
	 * Test createConcordanceFile method
	 * Create an input "TestB.txt" 
	 * and an output "TestOutB.txt"
	 */
	
	@Test
	public void testCreateConcordanceFileB() {
		ArrayList<String> words = new ArrayList<String>();
		try {
			input = new File("TestB.txt");
			PrintWriter inFile = new PrintWriter(input);
			inFile.print("Leadership does not mean domination.\n" + 
					"The world is always well supplied,\n" + 
					"with people who wish to rule and dominate\n" + 
					"others. The true leader is a\n" + 
					"different sort; he seeks effective\n" + 
					"activity which has a truly beneficient\n" + 
					"purpose. He inspires others to\n" + 
					"follow in his wake, and holding aloft\n" + 
					"the torch of wisdom, leads the way for\n" + 
					"society to realize its genuinely\n" + 
					"great aspirations.\n");
			inFile.close();
			output = new File("TestOutB.txt");
			PrintWriter outFile = new PrintWriter(output);
		 
			cdm.createConcordanceFile(input, output);
			Scanner scan = new Scanner(output);
			while (scan.hasNext())
			{
				words.add(scan.nextLine());
				
			}

			scan.close();
			outFile.close();
		for(int i=0; i<words.size(); i++)
			System.out.println(words.get(i));
		
			 
			assertEquals("activity: 6", words.get(0));
			assertEquals("aloft: 8", words.get(1));
			assertEquals("always: 2", words.get(2));
			assertEquals("aspirations: 11", words.get(3));
			assertEquals("beneficient: 6", words.get(4));
			assertEquals("domination: 1", words.get(8));
			assertEquals("genuinely: 10", words.get(12));
			assertEquals("leadership: 1", words.get(20));
			assertEquals("people: 3", words.get(25));
			assertEquals("realize: 10", words.get(27));
			assertEquals("society: 10", words.get(30));
			assertEquals("wisdom: 9", words.get(41));

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * Test createConcordanceFile method
	 * Create an input "TestC.txt" 
	 * and an output "TestOutC.txt"
	 */
	@Test
	public void testCreateConcordanceFileC() {
		try {
			input = new File("TestC.txt");
			input.setReadable(false);
			output = new File("TestOutC.txt");
			PrintWriter outFile = new PrintWriter(output);
			outFile.print(" ");
			
			cdm.createConcordanceFile(input, output);
			assertTrue("This should have raised an exception", false);
			outFile.close();
		
		} catch (FileNotFoundException e) {
			assertTrue("This should have raised a FileNotFoundexception", true);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * Test createConcordanceFile method
	 * Create an input "TestD.txt" 
	 * and an output "TestOutD.txt"
	 */
	@Test
	public void testCreateConcordanceFileD() {
		try {
			input = new File("TestD.txt");
			output = new File("TestOutD.txt");
			output.setWritable(false);
			
			cdm.createConcordanceFile(input, output);
			assertTrue("This should have raised an exception", false);
			
		} catch (FileNotFoundException e) {
			
			assertTrue("This should have raised a FileNotFoundException", true);
		}
	}
}

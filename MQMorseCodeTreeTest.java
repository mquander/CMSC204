import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Class to test MorseCodeTree methods
 * @author Matt Quander
 *
 */
class MQMorseCodeTreeTest {
	MorseCodeTree mct;
	
	@BeforeEach
	void setUp() throws Exception {
		mct = new MorseCodeTree();
	}

	@AfterEach
	void tearDown() throws Exception {
		mct = null;
	}
	/**
	 * Method to test fetch
	 */
	
	@Test
	void testFetch() {
		String letter = mct.fetch("...");
		assertEquals(letter, "s");
		
		letter = mct.fetch("--.");
		assertEquals(letter, "g");
		
		letter = mct.fetch("-.");
		assertEquals(letter, "n");
		
		letter = mct.fetch(".--.");
		assertEquals(letter, "p");
	}
	/**
	 * Method to test toArrayList
	 */
	@Test
	void testToArrayList() {
		ArrayList<String> testArray = new ArrayList<>();
		testArray = mct.toArrayList();
		ArrayList<String> expectedArray = new ArrayList<>();
		
		expectedArray.add("h");
		expectedArray.add("s");
		expectedArray.add("v");
		expectedArray.add("i");
		expectedArray.add("f");
		expectedArray.add("u");
		expectedArray.add("e");
		expectedArray.add("l");
		expectedArray.add("r");
		expectedArray.add("a");
		expectedArray.add("p");
		expectedArray.add("w");
		expectedArray.add("j");
		expectedArray.add("");
		expectedArray.add("b");
		expectedArray.add("d");
		expectedArray.add("x");
		expectedArray.add("n");
		expectedArray.add("c");
		expectedArray.add("k");
		expectedArray.add("y");
		expectedArray.add("t");
		expectedArray.add("z");
		expectedArray.add("g");
		expectedArray.add("q");
		expectedArray.add("m");
		expectedArray.add("o");
		assertEquals(testArray,expectedArray);
	}

}

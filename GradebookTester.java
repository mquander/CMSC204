import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Tests the methods of GradeBook class
 * @author Matthew Quander
 *
 */
class GradebookTester {
	GradeBook gb1;
	GradeBook gb2;
	/**
	 * Create two objects of GradeBook of size 5
	 * Add scores to those objects with the addScore method
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		gb1 = new GradeBook(5);
		gb2 = new GradeBook(5);
		gb1.addScore(89.3);
		gb1.addScore(78.4);

		gb2.addScore(77.1);
		gb2.addScore(96.0);
	}
	/**
	 * Deallocate the tow GradeBook objects by setting them to null
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		gb1 = null;
		gb2 = null;
	}
	/**
	 * Test addScore method adds scores to the array, compare 
	 * using string representation of array
	 */
	@Test
	void testAddScore() {
		assertTrue(gb1.toString().equals("89.3 78.4 "));
		assertTrue(gb2.toString().equals("77.1 96.0 "));
		
		assertEquals(2, gb1.getScoreSize());
		assertEquals(2, gb2.getScoreSize());

	}
	/**
	 * Test that sum returns the sum of the scores in
	 * the array
	 */
	@Test
	void testSum() {
		assertEquals(167.7, gb1.sum(), .01);
		assertEquals(173.1, gb2.sum(), .01);

	}
	/**
	 * Test that minimum method returns the lowest score
	 * or 0 if there are no scores
	 */
	@Test
	void testMinimum() {
		assertEquals(78.4, gb1.minimum(), .01);
		assertEquals(77.1, gb2.minimum(), .01);
	}
	/**
	 * Test that the finalScore method returns the sum
	 * of the scores dropping the lowest if at least 2 scores,
	 * or 0 if there no scores
	 */
	@Test
	void testFinalScore() {
		assertEquals(89.3, gb1.finalScore(), .01);
		assertEquals(96.0, gb2.finalScore(), .01);
	}

	@Test
	void testGetScoreSize() {
		assertEquals(2, gb1.getScoreSize());
		assertEquals(2, gb2.getScoreSize());

	}

	@Test
	void testToString() {
		assertTrue(gb1.toString().equals("89.3 78.4 "));
		assertTrue(gb2.toString().equals("77.1 96.0 "));

	}

}

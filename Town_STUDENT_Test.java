import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Town_STUDENT_Test {
	private Town t1, t2;
	private Road r1;
	@BeforeEach
	void setUp() throws Exception {
		t1 = new Town("Washington, D.C.");
		t2 = new Town("Baltimore");
		r1 = new Road(t1, t2, 20, "95");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		t1 = null;
		t2 = null;
		r1 = null;
	}
	@Test
	void testgetName() {
		String testTown = "Washington, D.C.";
		String testTown2 = "Baltimore";
		assertTrue(t1.getName() == testTown);
		assertFalse(t1.getName() == testTown2);
		//fail("Not yet implemented");
	}
	@Test
	void testCompareTo() {
		
		assertTrue(t1.compareTo(t1) == 0);
		assertFalse(t1.compareTo(t2) == 0);
		//fail("Not yet implemented");
	}
	
	

}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Road_STUDENT_Test {
	private Road r;
	@BeforeEach
	void setUp() throws Exception {
		
		r = new Road(new Town("Silver Spring"), new Town("Olney"), 11, "Georgia Ave");
	}

	@AfterEach
	void tearDown() throws Exception {
		r = null;
	}

	@Test
	void testContains() {
		Town town = new Town("Silver Spring");
		assertTrue(r.contains(town));
		//fail("Not yet implemented");
	}
	@Test
	void testgetSource() {
		Town town = new Town("Silver Spring");
		assertTrue(r.getSource().equals(town));
		//fail("Not yet implemented");
	}
	@Test
	void testgetDestination() {
		Town town = new Town("Olney");
		assertTrue(r.getDestination().equals(town));
		//fail("Not yet implemented");
	}
	@Test
	void testgetWeight() {
		
		assertTrue(r.getWeight() == 11);
		//fail("Not yet implemented");
	}
	@Test
	void testgetName() {
		String road = "Georgia Ave";
		assertTrue(r.getName() == road);
		//fail("Not yet implemented");
	}
	
}

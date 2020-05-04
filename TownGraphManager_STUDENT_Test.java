import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TownGraphManager_STUDENT_Test {
	
	TownGraphManager tgm;
	@BeforeEach
	void setUp() throws Exception {
		tgm = new TownGraphManager();
		tgm.addTown("Wheaton");
		tgm.addTown("Glenmont");
		tgm.addTown("Rockville");
		tgm.addTown("Bethesda");
		
		tgm.addRoad("Wheaton", "Glenmont", 2, "Georgia Ave");
		tgm.addRoad("Wheaton", "Rockville", 3, "Randolph Rd");
		tgm.addRoad("Rockville", "Bethesda", 5, "Rockville Pike");
	}

	@AfterEach
	void tearDown() throws Exception {
		tgm = null;
	}
	@Test
	public void testAddRoad() {
		ArrayList<String> roads = tgm.allRoads();
		assertEquals("Georgia Ave", roads.get(0));
		assertEquals("Randolph Rd", roads.get(1));
		assertEquals("Rockville Pike", roads.get(2));
				
	}
	@Test
	public void testGetRoad() {
		assertEquals("Georgia Ave", tgm.getRoad("Wheaton", "Glenmont"));
		assertEquals("Rockville Pike", tgm.getRoad("Rockville", "Bethesda"));
	}
	@Test
	public void testAddTown() {
		assertEquals(false, tgm.containsTown("College Park"));
		tgm.addTown("College Park");
		assertEquals(true, tgm.containsTown("College Park"));
	}
	@Test
	public void testContainsTown() {
		assertEquals(true, tgm.containsTown("Glenmont"));
	}
	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, tgm.containsRoadConnection("Wheaton", "Glenmont"));
		assertEquals(false, tgm.containsRoadConnection("Wheaton", "Bethesda"));
	}
	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, tgm.containsRoadConnection("Wheaton", "Glenmont"));
		tgm.deleteRoadConnection("Wheaton", "Glenmont", "Georgia Ave");
		assertEquals(false, tgm.containsRoadConnection("Wheaton", "Glenmont"));
	}
	@Test
	public void testDeleteTown() {
		assertEquals(true, tgm.containsTown("Rockville"));
		tgm.deleteTown("Rockville");
		assertEquals(false, tgm.containsTown("Rockville"));
	}
	@Test
	public void testGetPath() {
		ArrayList<String> path = tgm.getPath("Rockville", "Bethesda");
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Rockville via Rockville Pike to Bethesda 5 mi",path.get(0).trim());
		

	}
}

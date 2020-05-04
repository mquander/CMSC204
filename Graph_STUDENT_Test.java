import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Graph_STUDENT_Test {
	private GraphInterface<Town,Road> graph;
	private Town[] town;
	
	@BeforeEach
	void setUp() throws Exception {
		graph = new TownGraph();
		  town = new Town[5];
		  town[0] = new Town("Town_1");
		  town[1] = new Town("Town_2");
		  town[2] = new Town("Town_3");
		  town[3] = new Town("Town_4");
		  town[4] = new Town("Town_5");
		  
		  graph.addVertex(town[0]);
		  graph.addVertex(town[1]);
		  graph.addVertex(town[2]);
		  graph.addVertex(town[3]);
		  graph.addVertex(town[4]);
		 		  
		  graph.addEdge(town[0], town[1], 2, "Road_1");
		  graph.addEdge(town[0], town[2], 3, "Road_2");
		  graph.addEdge(town[1], town[3], 7, "Road_3");
		  graph.addEdge(town[2], town[3], 1, "Road_4");
		  graph.addEdge(town[3], town[4], 5, "Road_5");
	}

	@AfterEach
	void tearDown() throws Exception {
		graph = null;
	}

	@Test
	void testGetEdge() {
		assertEquals(new Road(town[1], town[0],2, "Road_1"), graph.getEdge(town[1], town[0]));
		assertEquals(new Road(town[1], town[3],7, "Road_3"), graph.getEdge(town[1], town[3]));
		assertEquals(new Road(town[0], town[2],3, "Road_2"), graph.getEdge(town[2], town[0]));
		assertEquals(new Road(town[4], town[3],5, "Road_5"), graph.getEdge(town[4], town[3]));
		//fail("Not yet implemented");
	}
	
	@Test
	public void testContainsEdge() {
		assertEquals(true, graph.containsEdge(town[2], town[3]));
		assertEquals(false, graph.containsEdge(town[0], town[3]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Town_2")));
		assertEquals(false, graph.containsVertex(new Town("Town_7")));
	}
	@Test
	public void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(town[2], town[3]));
		graph.removeEdge(town[2], town[3], 1, "Road_4");
		assertEquals(false, graph.containsEdge(town[2], town[3]));
	}
	
	@Test
	public void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(town[0]));
		graph.removeVertex(town[0]);
		assertEquals(false, graph.containsVertex(town[0]));
	}
	@Test
	  public void testTown_1ToTown_2() {
		  String beginTown = "Town_1", endTown = "Town_2";
		  Town beginIndex= new Town(beginTown), endIndex= new Town(endTown);
		 
		  if(beginIndex != null && endIndex != null)
		  {
			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_1 via Road_1 to Town_2 2 mi",path.get(0).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }

}

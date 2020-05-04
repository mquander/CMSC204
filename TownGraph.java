import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * Method to create graph
 * @author Matt Quander
 *
 */
public class TownGraph implements GraphInterface<Town, Road> {
	/**
	 * Class fields
	 */
	private Road newRoad1, newRoad2;
	private Road edge, edgeOther;
	//Town[] vertices;
	private ArrayList<Town> towns;
	private ArrayList<Road> roads;
	private Town destinationVertex;
	
	/**
	 * Constructor to initialize graph object
	 */
	public TownGraph() {
		towns = new ArrayList<>();
		roads = new ArrayList<>();
	}
	/**
	 * Method to get an edge to graph
	 * @param sourceVertex - the source vertex
	 * @param destinationVertex - the destination vertex
	 * @return r - the road between the vertices, if it exists
	 */
	@Override // does this have to return the name? this is called after addEdge?
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		// compute union set to get the edge
		for(Road r: roads) {
			if(r.getSource().equals(sourceVertex) && r.getDestination().equals(destinationVertex) ||
					r.getSource().equals(destinationVertex)  && r.getDestination().equals(sourceVertex))
				return r;				
		}
		return null;
		
	}
	/**
	 * Method to add an edge to graph
	 * @param sourceVertex - source vertex
	 * @param destinationVertex - destination vertex
	 * @param weight - Road weight
	 * @param description - Road name
	 * @return newRoad1 - new Road added
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(!towns.contains(sourceVertex) || !towns.contains(destinationVertex))
			throw new IllegalArgumentException("Towns are not in the graph");
		
		if(sourceVertex == null || destinationVertex == null)
			throw new NullPointerException();
		
		newRoad1 = new Road(sourceVertex, destinationVertex, weight, description);
		newRoad2 = new Road(destinationVertex, sourceVertex, weight, description);
		if(!roads.contains(newRoad1) && !roads.contains(newRoad2)) {
			roads.add(newRoad1);
			
		}
		sourceVertex.addConnection(newRoad1);
		destinationVertex.addConnection(newRoad1);
		
		return newRoad1;
	}
	/**
	 * Method to add a vertex to graph
	 * @param v - Town instance to add
	 * @return true or false if added
	 */
	@Override
	public boolean addVertex(Town v) {
		if(v == null)
			throw new NullPointerException();
		
		/*boolean duplicate = false;
		for(Town t: towns) {
			if(t.getName().equals(v.getName()))
				duplicate = true;
		}
		if(!duplicate) {
			towns.add(v);
			return true;
		}
		else
			return false;*/
		
		if(!towns.contains(v)) {
			
			towns.add(v);
			
			return true;
		}
		else
			return false;
	}
	/**
	 * Method to check of graph contains particular edge
	 * @param sourceVertex - source Town of edge
	 * @param destinationVertex - destination Town of edge
	 * @return true if contains, false if not
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		
		edge = this.getEdge(sourceVertex, destinationVertex);
		edgeOther = this.getEdge(destinationVertex, sourceVertex);
		
		if(roads.contains(edge) || roads.contains(edgeOther))
			return true;
		else
			return false;
	}
	/**
	 * Method to check if graph contains vertex
	 * @param v - Town instance to check
	 * @return true if contains, false if not
	 */
	@Override
	public boolean containsVertex(Town v) {
		
		return towns.contains(v);
		/*Set<Town> setOfTowns = map.keySet();
		if(setOfTowns.contains(v)) 
			return true;
		else
			return false;*/
	}
	/**
	 * Method to create Set of edges
	 * @return Set of edges
	 */
	@Override
	public Set<Road> edgeSet() {
		
		return new HashSet<>(roads);
	}
	/**
	 * Method to create Set of a Town's edges
	 * @param vertex - a Town instance
	 * @return roadsToReturn - Set of Roads
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		
		if(!towns.contains(vertex))
			throw new IllegalArgumentException("Town not in the graph");
		
		if(vertex == null)
			throw new NullPointerException();
		
		Set<Road> roadsToReturn = new HashSet<>();
		for(Road r: roads) {
			if(r.getSource() == vertex || r.getDestination() == vertex)
				roadsToReturn.add(r);
		}
		return roadsToReturn;
	}
	/**
	 * Method to remove a edge
	 * @param sourceVertex - source Town of edge
	 * @param destinationVertex - destination Town of edge
	 * @param weight - Road's weight
	 * @param description - Road's name
	 * @return tempRoad - Road removed, or null
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		Road tempRoad = null;
		Road roadToRemove = new Road(sourceVertex, destinationVertex, weight, description);
		Road roadToRemove2 = new Road(destinationVertex, sourceVertex, weight, description);
		for(Road r: roads) {
			if(r.compareTo(roadToRemove) == 0 || r.compareTo(roadToRemove2) == 0) {
				tempRoad = r;
				r = null;
				//return tempRoad;
			}
		}roads.remove(tempRoad);
		return tempRoad;
	}
	/**
	 * Method to remove vertex
	 * @param v - Town to remove
	 * @return true of removed, false otherwise
	 */
	@Override
	public boolean removeVertex(Town v) {
		
		if(towns.contains(v)) {
			towns.remove(v);
			for(Road r: roads) {
				if(r.getDestination() == v || r.getSource() == v) {
					roads.remove(r);
					return true;
				}
			}
		}
			
		return false;
	}
	/**
	 * Method to create a Set of vertices
	 * @return Set of Towns
	 */
	@Override
	public Set<Town> vertexSet() {
		
		return new HashSet<>(towns);
	}
	/**
	 * Method return the shortest path between two towns
	 * @param sourceVertex - source Town
	 * @param destinationVertex - destination Town
	 * @return shortestPathArray - array list of shortest path
	 */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
		Road r = null;
		this.destinationVertex = destinationVertex;
		this.dijkstraShortestPath(sourceVertex);
		
		String output = "";
		//shortestPathArray.add(sourceVertex.getName() + " via " + sourceVertex.getMinRoad() + " to " + sourceVertex.getMinRoad().getNeighbor(sourceVertex).toString() + " " + sourceVertex.getMinRoad().getWeight() + " mi");
		if(getEdge(sourceVertex, destinationVertex) != null) {
			output = (sourceVertex + " via " + getEdge(sourceVertex, destinationVertex) +" to " + destinationVertex + " " + getEdge(sourceVertex, destinationVertex).getWeight() + " mi");
			shortestPathArray.add(output);
			return shortestPathArray;
		}
		else {
		for (int i = 1; i < this.towns.size()-1; i++) {
			if(getEdge(sourceVertex, towns.get(i)) != null) {
				output += (sourceVertex + " via " + getEdge(sourceVertex, towns.get(i)) +" to " + towns.get(i) + " " + getEdge(sourceVertex, towns.get(i)).getWeight() + " mi");
				
			}shortestPathArray.add(output);
		}
		}
		
		return shortestPathArray;
	}
	
	String shortestPathString = "";
	ArrayList<String> shortestPathArray = new ArrayList<>();
	/**
	 * Method to create internal structure of shortest paths from 
	 * source vertex to all other vertices
	 * @param sourceVertex - source Town to find shortest paths from
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		
		Town[] townArray = new Town[towns.size()]; //new Town[vertexSet().size()];
		for(int i = 0; i < towns.size(); i++) {
			townArray[i] = towns.get(i);
		}
		for(int i = 0; i < townArray.length; i++) {
			if(townArray[i] == sourceVertex) {
				Town temp = townArray[0];
				townArray[0] = sourceVertex;
				townArray[i] = temp;
			}
		}
		sourceVertex.setDistanceFromSource(0);
		townArray[0].setDistanceFromSource(0);
		int nextTown = 0;
		Town neighbor = null;
		for(int i = 0; i < townArray.length; i++) {
			
			ArrayList<Road> currentEdges = townArray[nextTown].getConnections(); // sourceTown's edges
			
			for(int joinedEdge = 0; joinedEdge < currentEdges.size(); joinedEdge++) {
				
				neighbor = currentEdges.get(joinedEdge).getNeighbor(sourceVertex);
						
				if(!neighbor.isVisited()) {
					int potential = townArray[nextTown].getDistanceFromSource() + currentEdges.get(joinedEdge).getWeight();
					
					if(potential < neighbor.getDistanceFromSource()) {
						neighbor.setDistanceFromSource(potential);
						//shortestPathArray.add(String.valueOf(townArray[i].getName() + " via " + getEdge(sourceVertex, neighbor) + " to " + townArray[2]) + " " +getEdge(sourceVertex, townArray[2]).getWeight() + " mi"); // WHAT DO I ADD TO ARRAYLIST??
						//shortestPathString = String.valueOf(townArray[i].getName() + " via " + getEdge(sourceVertex, neighbor) + " to " + townArray[2]) + " " +getEdge(sourceVertex, townArray[2]).getWeight() + " mi";
					}
				
				}
			}
			townArray[nextTown].setVisited(true);
			
			nextTown++;
				
		}
		
		// Does this work???
	/*	Town[] townArray = (Town[])vertexSet().toArray(); //new Town[vertexSet().size()];
		Road[] roadArray = (Road[]) edgeSet().toArray();
		int[][] aCopy = new int[edgeSet().size()][edgeSet().size()];
		// create an adjacency matrix
		for(int i = 0; i < aCopy.length; i++) {
			for(int j = 0; j < aCopy.length; j++) {
				if(roadArray[j].getSource() == townArray[j] && roadArray[j].getDestination() == townArray[j])
					aCopy[i][j] = roadArray[j].getWeight();
			}
			
		}
		// set starting index for vertex in vertexArray
		int startVertex = 0;
		for(int k = 0; k < townArray.length; k++) {
			if(townArray[k] == sourceVertex)
				startVertex = k;
		}
		// find colMin and rowMin
		int colMin = aCopy[0][startVertex];
		for(int i = 0; i < aCopy.length; i++) {
			if(aCopy[startVertex][i] < colMin)
				colMin = aCopy[startVertex][i];
		}
		int minWeight = 0;
		int rowMin = aCopy[startVertex][0];
		for(int i = 0; i < aCopy.length; i++) {
			if(aCopy[i][startVertex] < colMin) {
				minWeight = aCopy[i][startVertex];
				rowMin = i;
			}
		}
				
		//  pseudocode
		int [] verticesIncluded = new int[vertexSet().size()];
		
		int numVerticesIncluded = 1;
		int numberOfVertices = vertexSet().size();
		
		Road noPath = null,  noEdge = null; // ????
		int[] minPathLengths = new int[edgeSet().size()];
		int spt[][] = new int[edgeSet().size()][edgeSet().size()];
		
		for(int i = 0; i < numberOfVertices; i++) {
			minPathLengths[i] = 0;
			aCopy[i][startVertex] = 0;
		}
		minPathLengths[startVertex] = 0;
		verticesIncluded[0] = startVertex;
		
		while(numVerticesIncluded < numberOfVertices) {
			//findMinPath(numberOfVertices, aCopy, verticesIncluded, numVerticesIncluded, minPathLengths, rowMin, colMin, minWeight, minPath);
			for(int i = 0; i < numberOfVertices; i++) {
				aCopy[i][colMin] = 0;
			}
			spt[rowMin][colMin] = minWeight;
			spt[colMin][rowMin] = minWeight;
			minPathLengths[colMin] = 0; // = minPath;
			verticesIncluded[numVerticesIncluded] = colMin;
			numVerticesIncluded++;
		}*/
		
		
		
	}
	/*private int getNodeShortestDistance() {
		
		Town[] townArray = new Town[towns.size()]; //new Town[vertexSet().size()];
		for(int i = 0; i < towns.size(); i++) {
			townArray[i] = towns.get(i);
		}
		
		int townIndex = 0;
		int townDistance = Integer.MAX_VALUE;
		
		for(int i = 0; i < townArray.length; i++) {
			int currentDistance = townArray[i].getDistanceFromSource();
			if(!townArray[i].isVisited() && currentDistance < townDistance) {
				townDistance = currentDistance;
				townIndex = i;
			}
		}
		
		return townIndex;
	}*/
	
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Class to manager graph
 * @author Matt Quander
 *
 */
public class TownGraphManager implements TownGraphManagerInterface{
	/**
	 * Class fields
	 */
	private Town newTown1, newTown2;
	private TownGraph tGraph;// = new TownGraph();
	
	/**
	 * Constructor to create manager instance
	 */
	public TownGraphManager(){
		tGraph = new TownGraph();
	}
	/**
	 * Method to add a Road to the graph
	 * @param town1 - name of one of the towns
	 * @param town2 - name of other town
	 * @param weight - weight of the Road to add
	 * @param roadName - name of the Road
	 * @return true or false if added
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		
		newTown1 = new Town(town1);
		newTown2 = new Town(town2);
		Road newRoad = new Road(newTown1, newTown2, weight, roadName);
		if(!tGraph.containsEdge(newTown1, newTown2) && !tGraph.containsEdge(newTown2, newTown1)) {
			tGraph.addEdge(newTown1, newTown2, weight, roadName);
			return true;
		}
		else
			return false;
	}
	/**
	 * Method to get a Road
	 * @param town1 - a Town connected by this Road
	 * @param town2 - other Town connected by this Road
	 * @return the road name
	 */
	@Override
	public String getRoad(String town1, String town2) {
		
		newTown1 = new Town(town1);
		newTown2 = new Town(town2);
		Road road = tGraph.getEdge(newTown1, newTown2);
		Road road2 = tGraph.getEdge(newTown2, newTown1);
		if(road.getName().equals(road2.getName()))
			return road.getName();
		else
			return road2.getName();
	}
	/**
	 * Method to add a Town
	 * @param v - name of the Town
	 * @return true or false if added
	 */
	@Override
	public boolean addTown(String v) {
		
		newTown1 = new Town(v);
		if(!tGraph.containsVertex(newTown1)) {
			tGraph.addVertex(newTown1);
			return true;
		}
		else
			return false;
	}
	/**
	 * Method to get a Town
	 * @param name - Town's name
	 * @return newTown1 - Town to return, or null
	 */
	@Override
	public Town getTown(String name) {
		
		newTown1 = new Town(name);
		
		if(tGraph.vertexSet().contains(newTown1) && tGraph.containsVertex(newTown1))
			return newTown1;
		else
			return null;
	}
	/**
	 * Method to check if graph contains Town
	 * @param v - Town's name
	 * @return true or false if contains
	 */
	@Override
	public boolean containsTown(String v) {
		
		newTown1 = new Town(v);
		if(tGraph.vertexSet().contains(newTown1) && tGraph.containsVertex(newTown1))
			return true;
		else
			return false;
	}
	/**
	 * Method to check if graph contains Road
	 * @param town1 - name of one Town
	 * @param town2 - name of other Towm
	 * @return true or false if contains
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		
		newTown1 = new Town(town1);
		newTown2 = new Town(town2);
		Road road = tGraph.getEdge(newTown1, newTown2);
		Road road2 = tGraph.getEdge(newTown2, newTown1);
		
		if(tGraph.containsEdge(newTown1, newTown2) || tGraph.containsEdge(newTown2, newTown1))
			return true; //  tGraph.edgeSet().contains(road) || tGraph.edgeSet().contains(road2)
		else
			return false;
	}
	/**
	 * Method to get all Roads
	 * @return roadNames - array list of the Road names
	 */
	@Override
	public ArrayList<String> allRoads() {
		
		ArrayList<Road> roads = new ArrayList<>(tGraph.edgeSet());
		ArrayList<String> roadNames = new ArrayList<>();
		for(Road o: roads)
			roadNames.add(o.getName());
		Collections.sort(roadNames);
		return roadNames;
		
	}
	/**
	 * Method to delete a connection
	 * @param town1 - one Town
	 * @param town2 - other Town
	 * @param road - Road name
	 * @return true or false if deleted
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		
		newTown1 = new Town(town1);
		newTown2 = new Town(town2);
		Road newRoad = tGraph.getEdge(newTown1, newTown2);
		if(tGraph.containsEdge(newTown1, newTown2)) {
			tGraph.removeEdge(newRoad.getSource(), newRoad.getDestination(), newRoad.getWeight(), newRoad.getName());
			return true;
		}
		else				
			return false;
	}
	/**
	 * Method to delete a Town
	 * @param v - Town name
	 * @return true or false if deleted
	 */
	@Override
	public boolean deleteTown(String v) {
		
		newTown1 = new Town(v);
		if(tGraph.removeVertex(newTown1))
			return true;
		else
			return false;
	}
	/**
	 * Method to get all Towns
	 * @return townNames - array list of Towns
	 */
	@Override
	public ArrayList<String> allTowns() {
		
		ArrayList<Town> towns = new ArrayList<>(tGraph.vertexSet());
		ArrayList<String> townNames = new ArrayList<>();
		
		for(Town o: towns)
			townNames.add(o.getName());
		Collections.sort(townNames);
		return townNames;
	}
	/**
	 * Method to get the path between 2 towns
	 * @param town1 - Town to get path from
	 * @param town2 - other Town
	 * @return array list of the path
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		return tGraph.shortestPath(t1, t2);
	}
	/**
	 * Method to populate the graph with Towns and Roads from a file
	 * @param selectedFile - file with Towns and Roads
	 * @throws FileNotFoundException - exception if can't find file
	 */
	public void populateTownGraph(File selectedFile) throws FileNotFoundException{
		
		String line;
		String[] tokens = new String[4];
		
		try {
			if(!selectedFile.canRead())
				throw new IOException();
		} catch (IOException e1) {
				e1.getMessage();
		}
		Scanner scan = new Scanner(selectedFile);
		while(scan.hasNextLine()) {
			line = scan.nextLine();
			line = line.replaceAll("[,;]", " ");
			tokens = line.split(" ");
			tGraph.addVertex(new Town(tokens[2]));
			tGraph.addVertex(new Town(tokens[3]));
			tGraph.addEdge(new Town(tokens[2]), new Town(tokens[3]), Integer.valueOf(tokens[1]), tokens[0]);
		}
		scan.close();
	}

}

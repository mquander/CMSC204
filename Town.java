import java.util.ArrayList;
/**
 * Class to create an instance of Town
 * @author Matt Quander
 *
 */
public class Town implements Comparable<Town>{
	/**
	 * Fields of the class
	 */
	private String name;
	private int distanceFromSource = Integer.MAX_VALUE;
	private boolean visited;
	private ArrayList<Road> connections; // = new ArrayList<>();
	/**
	 * Constructor to create Town object
	 * @param name - name of the Town to create
	 */
	public Town(String name) {
		this.name = name;
		connections = new ArrayList<>();
	}
	/**
	 * Constructor to copy town
	 * @param templateTown - Town to copy
	 */
	public Town(Town templateTown) {
		//templateTown.name  = this.name;
		new Town(templateTown.getName());
	}
	/**
	 * Method to get Town name
	 * @return name - Town name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Method to get Town name
	 * @return name - Town name
	 */
	@Override
	public String toString() {
		return name;
	}
	/**
	 * Method to compare Towns
	 * @param o - Town object to compare
	 * @return 0 if same, -1 if false
	 */
	public int compareTo(Town o) {
		if(this.getName() == o.getName())
			return 0;
		else
			return -1;		
	}
	/**
	 * Method to calculate Town hashcode
	 * @return result - int value of hashcode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/**
	 * Method to check of Town is equal
	 * @param obj - Object to check
	 * @return true if equal, false if not
	 */
	@Override
	public boolean equals(Object obj) {
		Town r = (Town) obj;
		if(this.getName().compareTo(r.getName()) == 0)
			return true;
		else
			return false;
		
		/*if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Town other = (Town) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;*/
	}
	/**
	 * Method to get Town's distance from source vertex
	 * @return distanceFromSource
	 */
	public int getDistanceFromSource() {
		return distanceFromSource;
	}
	/**
	 * Method to set Town's distance from source vertex
	 * @param distanceFromSource
	 */
	public void setDistanceFromSource(int distanceFromSource) {
		this.distanceFromSource = distanceFromSource;
	}
	/**
	 * Method to check if Town was visited
	 * @return visited - true or false
	 */
	public boolean isVisited() {
		return visited;
	}
	/**
	 * Method to set Town to visited or not visited
	 * @param visited - true or false value
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	/**
	 * Method to get array list of Town's connections
	 * @return connections - array list of Road objects
	 */
	public ArrayList<Road> getConnections() {
		return connections;
	}
	/**
	 * Method to add a Road to a Town's connections
	 * @param connection - Road instance to add
	 */
	public void addConnection(Road connection) {
		this.connections.add(connection);
	}
	/*public Road getMinRoad() {
		Road minRoad = connections.get(0);
		for(int i = 1; i <= this.connections.size()-1; i++) {
			if(minRoad.getWeight() > connections.get(i).getWeight())
				minRoad = connections.get(i);
		}
		return minRoad;
	}*/
}

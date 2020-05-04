/**
 * Class to create a Road object, an edge in the graph
 * @author Matt Quander
 *
 */
public class Road implements Comparable<Road>{
	/**
	 * Fields of the Road object
	 */
	private Town source, destination;
	private int weight;
	private String name;
	/**
	 * Constructors to create Road object
	 * @param source - the source Town of the road
	 * @param destination - the destination Town for the road
	 * @param degrees - the weight of the road
	 * @param name - name of the road
	 */
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		this.weight = degrees;
		this.name = name;		
	}
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.name = name;
	}
	/**
	 * Method to check if road contains given Town
	 * @param town - Town to check
	 * @return - true or false
	 */
	public boolean contains(Town town) {
		if(this.source.equals(town) || this.destination.equals(town))
			return true;
		else
			return false;
	}
	/**
	 * Method to return road name
	 * @return name
	 */
	@Override
	public String toString() {
		return name;
	}
	/**
	 * Method to return source Town of the road
	 * @return source - source town
	 */
	public Town getSource() {
		return source;
	}
	/**
	 * Method to get destination town
	 * @return destination - destination town
	 */
	public Town getDestination() {
		return destination;
	}
	/**
	 * Method to get road weight
	 * @return weight - road weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * Method to return road name
	 * @return name - road name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Method to check two roads
	 * @return 0 if same, -1 if not
	 */
	@Override
	public int compareTo(Road r) {
		if(this.name == r.name)
			return 0;
		else
			return -1;
	}
	@Override
	/**
	 * Method to check of two roads are equal
	 * @param r - an Object reference variable
	 * @return true or false if equal
	 */
	public boolean equals(Object r) {
		Road road = (Road) r;
		if(this.getName().compareTo(road.getName()) == 0)
			return true;
		else
			return false;
		
		/*if(this.source == road.source && this.destination == road.destination || 
				this.source == road.destination && this.destination == road.source)
			return true;
		else
			return false;*/
	}
	/**
	 * Method to get the neighbor of a town
	 * @param t - Town object to get neighbor of
	 * @return - neighbor of Town
	 */
	public Town getNeighbor(Town t) {
		
		if(this.getDestination().equals(t))
			return this.getSource();
		else 
			return this.getDestination();
		
	}

}

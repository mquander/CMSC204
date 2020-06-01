/**
 * Class to create Volunteer object
 * @author Matt Quander
 *
 */
public class Volunteer {
	/**
	 * Class field name
	 */
	private String name = "";
	/**
	 * Constructor to initialize object with name
	 * @param name
	 */
	public Volunteer(String n) {
		name = n;
	}
	/**
	 * Method to return volunteer name
	 * @return name of volunteer
	 */
	public String getName() {
		return name;
	}
	/**
	 * Method to set volunteer name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Method to return string representation of volunteer object
	 */
	public String toString() {
		
		return name;
	}
}

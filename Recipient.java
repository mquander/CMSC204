/**
 * Class to create Recipient object
 * @author Matt Quander
 *
 */
public class Recipient {
	/**
	 * Class fields
	 */
	private String name;
	/**
	 * Constructor to initialize Recipient object
	 * @param name Recipient's name
	 */
	public Recipient(String name) {
		this.name = name;
	}
	/**
	 * Method to get recipient's name
	 * @return name Recipient's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Method to set Recipient's name
	 * @param name String to pass and set field
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Method to return string representation of Recipient object
	 */
	public String toString() {
		return name;
	}
}

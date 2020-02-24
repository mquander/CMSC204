/**
 * Class to create DonationPAckage object
 * @author Matt Quander
 *
 */
public class DonationPackage {
	/**
	 * Class fields
	 */
	private String description;
	private double weight;
	/**
	 * Constructor to initialize object
	 * @param desc Description of package
	 * @param w Weight of package
	 */
	public DonationPackage(String desc, double w) {
		description = desc;
		weight = w;
	}
	/**
	 * Method to return description
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Method to set description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Method to return package weight
	 * @return weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * Method to set weight
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * Method to return string version of package
	 */
	public String toString() {
		return description;
	}
	/**
	 * Method to check if package weight is too heavy
	 * @return true if too heavy, false if not
	 */
	public boolean isHeavy() {
		if(getWeight() >= 20.0) 
			return true;
		else
			return false;
	}
}

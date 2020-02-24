/**
 * Exception class for Volunteer
 * @author Matt Quander
 *
 */
@SuppressWarnings("serial")
public class VolunteerException extends RuntimeException {
	public VolunteerException() {}
	/**
	 * Constructor to print string message passed to it
	 * @param message
	 */
	public VolunteerException(String message) {
		super(message);
	}
	
}

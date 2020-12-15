/**
 * Exception class for passwords less than 6 characters long
 * @author
 *
 */
@SuppressWarnings("serial")
public class LengthException extends Exception {
	/**
	 * No-arg constructor to call super constructor with message passed
	 */
	public LengthException() {
		super("The password must be at least 6 characters long");
	}
}

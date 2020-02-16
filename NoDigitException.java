/**
 * Exception class for passwords with no digits
 * @author Matthew Quander
 *
 */
@SuppressWarnings("serial")
public class NoDigitException extends Exception {
	/**
	 * No-arg constructor to call super constructor with message passed
	 */
	public NoDigitException() {
		super("The password must contain at least one digit");
	}
}

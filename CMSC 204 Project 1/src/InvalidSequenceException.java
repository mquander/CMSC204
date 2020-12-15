/**
 * Exception class for passwords with more that 2 characters in sequence
 * @author 
 *
 */
@SuppressWarnings("serial")
public class InvalidSequenceException extends Exception {
	/**
	 * No-arg constructor to call super constructor with message passed
	 */
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence.");
	}
}

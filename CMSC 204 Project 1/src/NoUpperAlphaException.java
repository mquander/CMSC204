/**
 * Exception class for passwords with no uppercase characters
 * @author 
 *
 */
@SuppressWarnings("serial")
public class NoUpperAlphaException extends Exception {
	/**
	 * No-arg constructor to call super constructor with message passed
	 */
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
}

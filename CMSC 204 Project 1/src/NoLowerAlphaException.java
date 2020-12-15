/**
 * Exception class for passwords with no lowercase characters
 * @author
 *
 */
@SuppressWarnings("serial")
public class NoLowerAlphaException extends Exception {
	/**
	 * No-arg constructor to call super constructor with message passed
	 */
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");
	}
}

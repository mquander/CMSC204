/**
 * Exception class for entered passwords that do not match
 * @author
 *
 */
@SuppressWarnings("serial")
public class UnmatchedException extends Exception {
	/**
	 * No-arg constructor to call super constructor with message passed
	 */
	public UnmatchedException() {
		super("The passwords do not match");
	}
}

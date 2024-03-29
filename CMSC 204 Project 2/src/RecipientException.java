/**
 * Exception class for recipient
 * @author
 *
 */
@SuppressWarnings("serial")
public class RecipientException extends RuntimeException {
	public RecipientException() {}
	/**
	 * Constructor to print string message passed to it
	 * @param message
	 */
	public RecipientException(String message) {
		super(message);
	}
}

/**
 * Exception class for Container 
 * @author 
 *
 */
@SuppressWarnings("serial")
public class ContainerException extends RuntimeException {
	public ContainerException() {}
	/**
	 * Constructor to print string message passed to it
	 * @param message
	 */
	public ContainerException(String message) {
		super(message);
	}
}

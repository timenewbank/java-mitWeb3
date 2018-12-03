package mit.utils.exceptions;

/**
 * Encoding exception.
 */
public class MessageDecodingException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2119540663129500778L;

	public MessageDecodingException(String message) {
        super(message);
    }

    public MessageDecodingException(String message, Throwable cause) {
        super(message, cause);
    }
}

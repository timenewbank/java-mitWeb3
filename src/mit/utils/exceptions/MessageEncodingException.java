package mit.utils.exceptions;

/**
 * Encoding exception.
 */
public class MessageEncodingException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6097193601198989474L;

	public MessageEncodingException(String message) {
        super(message);
    }

    public MessageEncodingException(String message, Throwable cause) {
        super(message, cause);
    }
}

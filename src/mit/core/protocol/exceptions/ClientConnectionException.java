package mit.core.protocol.exceptions;

/**
 * Client connection exception.
 */
public class ClientConnectionException extends RuntimeException {
    public ClientConnectionException(String message) {
        super(message);
    }

}

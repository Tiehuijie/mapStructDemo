package mapStructDemo.exception;

public class InvalidMapperException extends RuntimeException {
    public InvalidMapperException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMapperException(String message) {
        super(message);
    }
}

package exceptions;

public class InvalidItemDetailsException extends RuntimeException {
	
	public InvalidItemDetailsException (String message) {
		super(message);
	}
}

package exceptions;

public class InvalidItemNameFormatException extends RuntimeException {

	public InvalidItemNameFormatException() {
		super("Item name must contain letters only");
	}
}

package exceptions;

// we can throw this exception when user add new item or update on item with Invalid data such as null name , price with negative , total number with negative
public class InvalidItemDataException extends RuntimeException {
	
	public InvalidItemDataException (String message) {
		super (message);
	}
	
}

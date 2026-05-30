package exceptions;

public class ItemDetailsNotFoundException extends RuntimeException {
	
	public ItemDetailsNotFoundException () {
		super("No details found for this item");
	}
	
}

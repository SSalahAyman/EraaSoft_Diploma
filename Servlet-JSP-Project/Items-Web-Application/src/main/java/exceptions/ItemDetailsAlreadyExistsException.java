package exceptions;

public class ItemDetailsAlreadyExistsException extends RuntimeException {
	
	public ItemDetailsAlreadyExistsException () {
		
		super ("This item already has details");
		
	}

}

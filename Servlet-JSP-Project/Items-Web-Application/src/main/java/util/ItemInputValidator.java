package util;

import java.util.Objects;

import exceptions.InvalidItemDataException;
import exceptions.InvalidItemNameFormatException;
import exceptions.MissingMandatoryField;
import model.Item;

public class ItemInputValidator {
	
	public static void validateAddItemInputs (Item item) {
		validateNameInput(item.getName());
		validatePriceInput(item.getPrice());
		validateTotalQuantityInput(item.getTotalNumber());
		
	} 
	
	public static void validateUpdateItemInputs (Item item) {
		validateNameInput(item.getName());
		validatePriceInput(item.getPrice());
		validateTotalQuantityInput(item.getTotalNumber());
		
		} 
	
	public static void validateNameInput(String name) {
		
		if(Objects.isNull(name) || name.trim().isEmpty()) {
			throw new MissingMandatoryField();
		}
		
		// // letters + spaces only
		if (!name.matches("^[a-zA-Z ]+$")) {
			throw new InvalidItemNameFormatException();
		}
		
		
	}
	
	public static void validatePriceInput(double price) {
			
			if (Objects.isNull(price)) {
				throw new MissingMandatoryField();
			}
			
			if (price <=0) {
				throw new InvalidItemDataException("Price must be greater than 0");
			}
					
			
		}

	 public static void validateTotalQuantityInput(Integer totalNumber) {
		
		if(Objects.isNull(totalNumber)) {
			throw new MissingMandatoryField();
		}
		
		if (totalNumber < 0) {
			throw new InvalidItemDataException("Total quantity must be greater than or equal 0");
		}
		
		
	}
//	public static boolean isValidateAddItemInputs(Item item) {
//		
//		return isValidName(item.getName())
//				&&isValidPrice(item.getPrice())
//				&& isValidTotalNumber(item.getTotalNumber());
//	}
//	
//	public static boolean isValidateUpdateitemInputs(Item item) {
//		return isValidName(item.getName())
//				&&isValidPrice(item.getPrice())
//				&& isValidTotalNumber(item.getTotalNumber());
//	}
//	
//	public static boolean isValidName(String name) {
//
//        return Objects.nonNull(name) && !name.trim().isEmpty();
//    }
//
//    public static boolean isValidPrice(double price) {
//
//        return price > 0;
//    }
//
//    public static boolean isValidTotalNumber(int totalNumber) {
//
//        return totalNumber >= 0;
//    }
	
	
}

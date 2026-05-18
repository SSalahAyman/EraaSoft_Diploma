package util;

import java.util.Objects;

import model.Item;

public class ItemInputValidator {
	
	public static boolean isValidateAddItemInputs(Item item) {
		
		return isValidName(item.getName())
				&&isValidPrice(item.getPrice())
				&& isValidTotalNumber(item.getTotalNumber());
	}
	
	public static boolean isValidateUpdateitemInputs(Item item) {
		return isValidName(item.getName())
				&&isValidPrice(item.getPrice())
				&& isValidTotalNumber(item.getTotalNumber());
	}
	
	public static boolean isValidName(String name) {

        return Objects.nonNull(name) && !name.trim().isEmpty();
    }

    public static boolean isValidPrice(double price) {

        return price > 0;
    }

    public static boolean isValidTotalNumber(int totalNumber) {

        return totalNumber >= 0;
    }
	
	
}

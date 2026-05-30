package util;

import java.util.Objects;

import exceptions.InvalidItemDetailsException;
import model.ItemDetails;

public class ItemDetailsInputValidator {
	
	public static void validateAddItemDetailsInputs (ItemDetails itemDetails) {
		validateDescriptionInput(itemDetails.getDescription());
		validateColorInput(itemDetails.getColor());
		validateWeightInput(itemDetails.getWeight());
		validateBrandInput(itemDetails.getBrand());
		
	} 
	
	public static void validateUpdateItemDetailsInputs (ItemDetails itemDetails) {
		validateDescriptionInput(itemDetails.getDescription());
		validateColorInput(itemDetails.getColor());
		validateWeightInput(itemDetails.getWeight());
		validateBrandInput(itemDetails.getBrand());
		
		} 
	
	
	public static void validateDescriptionInput(String description) {
			
			if(Objects.isNull(description) || description.trim().isEmpty()) {
				
				throw new InvalidItemDetailsException("Description is required");
				
			}
			
			
		}
	
	public static void validateColorInput(String color) {
		
		if(Objects.isNull(color) || color.trim().isEmpty()) {
			throw new InvalidItemDetailsException("color is required");
		}
		
		// letters + spaces only
		if (!color.matches("^[a-zA-Z ]+$")) {
			
			throw new InvalidItemDetailsException("Item color must contain letters only");
			
		}
		
	}
	
	public static void validateWeightInput(Double weight) {
			
			if(Objects.isNull(weight) ) {
				
				throw new InvalidItemDetailsException("weight is required");
			}
			
			if (weight <=0) {
				
				throw new InvalidItemDetailsException("Weight Must Be Greater Than Zero");
			}
			
		}
	
	public static void validateBrandInput(String brand) {
		
		if(Objects.isNull(brand) || brand.trim().isEmpty() ) {
			
			throw new InvalidItemDetailsException("brand is required");
		}
		
		// letters + spaces only
		if (!brand.matches("^[a-zA-Z ]+$")) {
					
			throw new InvalidItemDetailsException("Item brand must contain letters only");
					
		}
		
	}

	
}

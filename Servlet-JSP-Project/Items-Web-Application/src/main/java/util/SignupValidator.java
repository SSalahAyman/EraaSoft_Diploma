package util;

import java.util.Objects;

public class SignupValidator {
	
	public static ValidationResult validateSignupInputs(String username,String password, String confirmPassword) {
		
		// userName validation
		if(Objects.isNull(username) || username.trim().isEmpty()) {
			return new ValidationResult (false,"Username is required");
		}
		
		if(username.length() <3) {
			return new ValidationResult(false , "username must be at least 3 characters");
		}
		
		
		// password validation
		if(Objects.isNull(password) || password.trim().isEmpty()) {
			return new ValidationResult (false,"password is required");
		}
		
		if(password.length() < 6) {
			return new ValidationResult(false , "password must be at least 6 characters");
		}
		
		if(!password.matches( "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$")) {  // that mean must password must contain capital letter and small letter and number atLeast
			return new ValidationResult(false , "not strong password , please make it  contain capital letter and small letter and number ");
		}
		
		
		// confirm password validation
		if(Objects.isNull(confirmPassword)|| confirmPassword.trim().isEmpty()) {
			return new ValidationResult(false,"Confirm password is required");
        }
		
		if(!password.equals(confirmPassword)) {
			return new ValidationResult(false,"Passwords do not match");
		}
		
		
		return new ValidationResult (true,"validation success");
		
	}
}

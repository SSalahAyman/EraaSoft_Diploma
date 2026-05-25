package util;

import java.util.Objects;

import exceptions.MissingMandatoryField;
import exceptions.PasswordMismatchException;
import exceptions.ValidationException;

public class SignupValidator {
	
	public static void validateSignupInputs(String username,String password, String confirmPassword) {
		
		// userName validation
		if (Objects.isNull(username) || username.trim().isEmpty()) {
			throw new MissingMandatoryField();
		}
		
		if (username.length() <3 ) {
			throw new ValidationException("Username must be at least 3 characters");
		}
		
		// password validation
		if(Objects.isNull(password) || password.trim().isEmpty()) {
			throw new MissingMandatoryField();
		}
		
		if (password.length() <6 ) {
			throw new ValidationException("password must be at least 6 characters");
		}
		
		if(!password.matches( "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$")) {
			throw new ValidationException("Password must contain uppercase, lowercase and number");
		}
		
		// confirm password validation
		if(Objects.isNull(confirmPassword)|| confirmPassword.trim().isEmpty()) {
			throw new MissingMandatoryField();
        }
		
		if(!password.equals(confirmPassword)) {
			throw new PasswordMismatchException();
		}
		
		
//		if(Objects.isNull(username) || username.trim().isEmpty()) {
//			return new ValidationResult (false,"Username is required");
//		}
//		
//		if(username.length() <3) {
//			return new ValidationResult(false , "username must be at least 3 characters");
//		}
//		
//		
//		// password validation
//		if(Objects.isNull(password) || password.trim().isEmpty()) {
//			return new ValidationResult (false,"password is required");
//		}
//		
//		if(password.length() < 6) {
//			return new ValidationResult(false , "password must be at least 6 characters");
//		}
//		
//		if(!password.matches( "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$")) {  // that mean must password must contain capital letter and small letter and number atLeast
//			return new ValidationResult(false , "not strong password , please make it  contain capital letter and small letter and number ");
//		}
//		
//		
//		// confirm password validation
//		if(Objects.isNull(confirmPassword)|| confirmPassword.trim().isEmpty()) {
//			return new ValidationResult(false,"Confirm password is required");
//        }
//		
//		if(!password.equals(confirmPassword)) {
//			return new ValidationResult(false,"Passwords do not match");
//		}
//		
//		
//		return new ValidationResult (true,"validation success");
		
	}
}

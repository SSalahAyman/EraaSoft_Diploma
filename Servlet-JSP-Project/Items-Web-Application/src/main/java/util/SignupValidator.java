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
		
	}
}

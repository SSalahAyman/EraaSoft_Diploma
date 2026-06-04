package util;

import java.util.Objects;

import exceptions.MissingMandatoryField;
import exceptions.PasswordMismatchException;
import exceptions.ValidationException;

public class AuthInputValidator {
	
	public static void validateSignupInputs(String username,String password,String confirmPassword) {

        validateUsername(username);
        validatePassword(password);
        validatePasswordConfirmation(password, confirmPassword);
        
        
    }

    public static void validateLoginInputs(String username,String password) {

        if (Objects.isNull(username)|| username.trim().isEmpty()) {

            throw new MissingMandatoryField();
        }

        if (Objects.isNull(password)|| password.trim().isEmpty()) {

            throw new MissingMandatoryField();
        }
    }

    public static void validateResetPasswordInputs( String newPassword,String confirmPassword) {

        validatePassword(newPassword);

        validatePasswordConfirmation(newPassword, confirmPassword);
        
    }

    public static void validateUsername(String username) {

        if (Objects.isNull(username)|| username.trim().isEmpty()) {

            throw new MissingMandatoryField();
        }

        if (username.length() < 3) {

            throw new ValidationException( "Username must be at least 3 characters");
        }
    }

    public static void validatePassword(String password) {

        if (Objects.isNull(password)|| password.trim().isEmpty()) {

            throw new MissingMandatoryField();
        }

        if (password.length() < 6) {

            throw new ValidationException( "Password must be at least 6 characters");
        }

        if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$")) {

            throw new ValidationException( "Password must contain uppercase, lowercase and number");
        }
    }
    
    public static void validatePasswordConfirmation(String password,String confirmPassword) {
    	
    	if (Objects.isNull(confirmPassword)|| confirmPassword.trim().isEmpty()) {

            throw new MissingMandatoryField();
        }

        if (!password.equals(confirmPassword)) {
            throw new PasswordMismatchException();
        }
        
    }
}


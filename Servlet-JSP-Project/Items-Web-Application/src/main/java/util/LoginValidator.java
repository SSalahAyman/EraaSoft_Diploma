package util;

import java.util.Objects;

import exceptions.MissingMandatoryField;

public class LoginValidator {
	
	public static void validateLoginInputs(String username,String password) {
		
		if (Objects.isNull(username) || username.trim().isEmpty()) {
			throw new MissingMandatoryField();
		}
		
		if (Objects.isNull(password) || password.trim().isEmpty()) {
			throw new MissingMandatoryField();
		}
	}
}

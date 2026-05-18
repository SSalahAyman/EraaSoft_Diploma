package service.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import model.User;
import repo.UserRepo;
import repo.impl.UserRepoImpl;
import service.AuthService;
import util.SignupValidator;
import util.ValidationResult;

public class AuthServiceImpl implements AuthService {
	
	UserRepo userRepo = new UserRepoImpl();

	@Override
	public ValidationResult signup(HttpServletRequest request) {
		String userName= request.getParameter("username");
		
		String password = request.getParameter("password");
		
		String confirmPassword = request.getParameter("confirmPassword");
		
		// validation
		ValidationResult validationResult = SignupValidator.validateSignupInputs(userName, password, confirmPassword);
		
	  // this mean if this condition acheives that mean the validation on inputs of signin is failed , so return the validationResult that contain boolean flag and message error to Auth controller
		if (!validationResult.isValid()) {  
			return validationResult;
		}
		
		// create user object with the input data after validation is successed
		User user = new User(userName,password);
		
		// create account with this userObject and with checking on the userName is already exists or not before
		
		try {
			boolean isUserCreated = userRepo.createAccount(user);
			if (isUserCreated) {
				return new ValidationResult(true,"SignupSuccess");
			}
		} catch (SQLException e) {
			 // Oracle UNIQUE constraint if is not achieved
			if(e.getErrorCode() == 1) {

	            return new ValidationResult(false,"Username already exists");
	        }

	        e.printStackTrace();
		}
		
		
		return new ValidationResult(false,"Signup failed");
	}

}

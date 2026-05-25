package service.impl;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import exceptions.InvalidCredentialsException;
import exceptions.MissingMandatoryField;
import exceptions.PasswordMismatchException;
import exceptions.UserAlreadyExistsException;
import exceptions.ValidationException;
import model.User;
import repo.UserRepo;
import repo.impl.UserRepoImpl;
import service.AuthService;
import util.LoginValidator;
import util.SignupValidator;


public class AuthServiceImpl implements AuthService {
	
	private UserRepo userRepo = new UserRepoImpl();

	@Override
	public void signup(HttpServletRequest request) throws MissingMandatoryField,PasswordMismatchException,ValidationException,NamingException, SQLException {
		String userName= request.getParameter("username");
		
		String password = request.getParameter("password");
		
		String confirmPassword = request.getParameter("confirmPassword");
		
		// validation
		SignupValidator.validateSignupInputs(userName, password, confirmPassword);
		
		// create user object with the input data after validation is successed
		User user = new User(userName,password);
		
		// create account with this userObject and with checking on the userName is already exists or not before
		try {
			userRepo.createAccount(user);
			
		} catch (SQLException e) {
			
			// ORACLE UNIQUE CONSTRAINT
			if (e.getErrorCode() == 1) {
				throw new UserAlreadyExistsException();			
			}
			
			throw e;
		}
		
		
	}

	@Override
	public User login(HttpServletRequest request) throws NamingException, SQLException, MissingMandatoryField {
		
		String userName = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		// validation
		LoginValidator.validateLoginInputs(userName, password);
		
		User receivedUser = userRepo.login(userName, password);
		
		if (receivedUser == null) {
			throw new InvalidCredentialsException();
		}
		
		return receivedUser;
		
	}

}

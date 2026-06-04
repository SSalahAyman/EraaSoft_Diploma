package service.impl;

import java.sql.SQLException;
import java.util.Objects;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exceptions.InvalidCredentialsException;
import exceptions.MissingMandatoryField;
import exceptions.PasswordMismatchException;
import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import exceptions.ValidationException;
import model.User;
import repo.UserRepo;
import repo.impl.UserRepoImpl;
import service.AuthService;
import util.AuthInputValidator;
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
		AuthInputValidator.validateSignupInputs(userName, password, confirmPassword);
		
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
		AuthInputValidator.validateLoginInputs(userName, password);
		
		User receivedUser = userRepo.login(userName, password);
		
		if (receivedUser == null) {
			throw new InvalidCredentialsException();
		}
		
		HttpSession session = request.getSession();
		 
		session.setAttribute("userId",receivedUser.getId());
		
		return receivedUser;
		
	}

	@Override
	public void checkUsername(String username) throws SQLException, NamingException ,MissingMandatoryField, UserNotFoundException {
		
		if (Objects.isNull(username) || username.trim().isEmpty()) {
			
			throw new MissingMandatoryField();
			
		}
		
		User user = userRepo.findByUsername(username);
		
		if(user == null) {
			
			 throw new UserNotFoundException();
			 
		}
		
		
	}

	@Override
	public void resetPassword(String username, String password, String confirmPassword) throws SQLException, NamingException , MissingMandatoryField,PasswordMismatchException,ValidationException {
		
		AuthInputValidator.validatePassword(password);
		
		AuthInputValidator.validatePasswordConfirmation(password, confirmPassword);
		
		userRepo.updatePassword(username, confirmPassword);
		
		
	}

}

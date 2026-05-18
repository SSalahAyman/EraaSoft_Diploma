package service;

import javax.servlet.http.HttpServletRequest;

import util.ValidationResult;

public interface AuthService {
	
	ValidationResult signup(HttpServletRequest request); 
	
	

}

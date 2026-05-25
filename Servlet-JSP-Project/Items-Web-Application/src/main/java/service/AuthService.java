package service;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import model.User;


public interface AuthService {
	
	void signup(HttpServletRequest request) throws SQLException, NamingException ; 
	
	User login(HttpServletRequest request) throws SQLException, NamingException ;

}

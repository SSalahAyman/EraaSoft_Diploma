package repo;

import java.sql.SQLException;

import javax.naming.NamingException;

import model.User;

public interface UserRepo {
	
	void createAccount(User user) throws NamingException , SQLException ;
	
	User login(String userName , String password) throws NamingException , SQLException;
	
	User findByUsername(String username) throws NamingException , SQLException ;
	
	void updatePassword(String username , String password) throws NamingException , SQLException;
	
	
}

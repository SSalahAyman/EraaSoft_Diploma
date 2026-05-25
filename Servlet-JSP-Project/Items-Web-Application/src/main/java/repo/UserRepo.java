package repo;

import java.sql.SQLException;

import javax.naming.NamingException;

import model.User;

public interface UserRepo {
	
	void createAccount(User user) throws NamingException , SQLException ;
	
	User login(String userName , String password) throws NamingException , SQLException;

    // boolean isUsernameExists(String username);
}

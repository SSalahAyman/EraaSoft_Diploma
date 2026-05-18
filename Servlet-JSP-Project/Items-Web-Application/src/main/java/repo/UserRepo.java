package repo;

import java.sql.SQLException;

import model.User;

public interface UserRepo {
	
	boolean createAccount(User user) throws SQLException;

    // boolean isUsernameExists(String username);
}

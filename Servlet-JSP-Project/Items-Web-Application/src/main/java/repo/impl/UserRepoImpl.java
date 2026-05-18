package repo.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import javax.naming.NamingException;

import database.DBConfig;
import exceptions.UserAlreadyExistsException;
import model.User;
import repo.UserRepo;

public class UserRepoImpl implements UserRepo {

	@Override
	public boolean createAccount(User user) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection= DBConfig.getConnection();
			String query = "INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			int rowsAffected = preparedStatement.executeUpdate();
			
			if (rowsAffected == 0) {
				throw new UserAlreadyExistsException();
			}
			return rowsAffected == 1;
			
		} catch (NamingException | SQLException e) {
			
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(connection)) {
				try {
					connection.close();
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}

}

package repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import javax.naming.NamingException;

import database.DBConfig;
import model.User;
import repo.UserRepo;

public class UserRepoImpl implements UserRepo {

	@Override
	public void createAccount(User user) throws NamingException, SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
		connection = DBConfig.getConnection();
		String query = "INSERT INTO USERS (USERNAME,PASSWORD) VALUES (?,?)";
		
		preparedStatement  = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		
		preparedStatement.executeUpdate();
		
		} finally {
			if (Objects.nonNull(connection)) {
				connection.close();
			}
			
			if(preparedStatement != null) {
		        preparedStatement.close();
		    }
		}
	
		
		
		
//		try {
//			connection= DBConfig.getConnection();
//			String query = "INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?,?)";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, user.getUsername());
//			preparedStatement.setString(2, user.getPassword());
//			int rowsAffected = preparedStatement.executeUpdate();
//			
//			if (rowsAffected == 0) {
//				throw new UserAlreadyExistsException();
//			}
//			return rowsAffected == 1;
//			
//		//} catch (NamingException | SQLException e) {
//			
//			//e.printStackTrace();
//		}
//	finally {
//			if (Objects.nonNull(connection)) {
//				try {
//					connection.close();
//					preparedStatement.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		
		//return false;
	}

	@Override
	public User login(String userName , String password) throws NamingException , SQLException {
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBConfig.getConnection();
			String query = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			User user = null;
			if(resultSet.next()) {
				user = new User(
						resultSet.getInt("ID"),
						resultSet.getString("USERNAME"),
						resultSet.getString("PASSWORD")
			     );
			}
			
			return user;
		  } 
		finally {
			if (Objects.nonNull(connection)) {
				connection.close();
			}
			
			if(preparedStatement != null) {
		        preparedStatement.close();
		    }
		}
		
		
	}

}

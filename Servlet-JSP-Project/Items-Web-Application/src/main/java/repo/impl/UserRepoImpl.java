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

	@Override
	public User findByUsername(String username) throws NamingException, SQLException {
		
		Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    
	    try {

	        connection = DBConfig.getConnection();

	        String query ="SELECT * FROM USERS WHERE USERNAME = ?";

	        preparedStatement =connection.prepareStatement(query);

	        preparedStatement.setString(1, username);

	        ResultSet resultSet =preparedStatement.executeQuery();

	        User user = null;

	        if (resultSet.next()) {

	            user = new User(
	                    resultSet.getInt("ID"),
	                    resultSet.getString("USERNAME"),
	                    resultSet.getString("PASSWORD")
	            );
	        }

	        return user;

	    } finally {

	        if (connection != null) {
	            connection.close();
	        }

	        if (preparedStatement != null) {
	            preparedStatement.close();
	        }
	    }
		
	}

	@Override
	public void updatePassword(String username, String password) throws NamingException, SQLException {
		
		Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    try {

	        connection = DBConfig.getConnection();

	        String query ="UPDATE USERS SET PASSWORD = ? WHERE USERNAME = ?";

	        preparedStatement =connection.prepareStatement(query);

	        preparedStatement.setString(1, password);
	        preparedStatement.setString(2, username);

	        preparedStatement.executeUpdate();

	    } finally {

	        if (connection != null) {
	            connection.close();
	        }

	        if (preparedStatement != null) {
	            preparedStatement.close();
	        }
	    }
		
	}

}

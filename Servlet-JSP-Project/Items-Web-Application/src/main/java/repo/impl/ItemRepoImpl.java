package repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.naming.NamingException;

import database.DBConfig;
import model.Item;
import repo.ItemRepo;

// this class is mainly to interact with the database in ITEM table with any function that are defined within in the class , and each fucntion produce specific action on the TABLE ITEM in database and return a result of this action from database
public class ItemRepoImpl implements ItemRepo {
	
	// private DataSource dataSource;  // here define the dataSource attribute , and the intialziation or it's value that is sending by the constructor during the creation of object
	
	/* here defined this parameterized constructor because to make anyone that want create object from ItemRepo class must send dataSource object that is store a connection , that is this class needs 
	 * this dataSource object to can use it for get the connection to can interact with the database with table Item
	 * So , here when creating object from this class , we must send dataSource object , and the constructor is received the object and store it in the dataSource private attribute that we defined in this class
	 * to make any function of the class uses it and get a connection , then can write query and executed it in the database
	 */
//	public ItemRepoImpl() {
//		if(Objects.isNull(dataSource)) {
//			throw new IllegalArgumentException("DataSource must not be null");
//		}
//	}

	@Override
	public List<Item> getAllItems() throws NamingException, SQLException {
		Connection connection = null; 
		PreparedStatement preparedStatement = null;
		List<Item> items = new ArrayList();
		
		try {
			connection = DBConfig.getConnection();
			
			// String query = "SELECT * FROM ITEM";
			
			String query = " SELECT i.ID,\r\n"
					+ "       i.NAME,\r\n"
					+ "       i.PRICE,\r\n"
					+ "       i.TOTAL_NUMBER,\r\n"
					+ "\r\n"
					+ "       CASE\r\n"
					+ "           WHEN EXISTS (\r\n"
					+ "               SELECT 1\r\n"
					+ "               FROM ITEM_DETAILS d\r\n"
					+ "               WHERE d.ITEM_ID = i.ID\r\n"
					+ "           )\r\n"
					+ "           THEN 1\r\n"
					+ "           ELSE 0\r\n"
					+ "       END AS HAS_DETAILS\r\n"
					+ "\r\n"
					+ "FROM ITEM i";
			
//			String query = """
//			 SELECT i.ID,i.NAME,i.PRICE,i.TOTAL_NUMBER
//					CASE 
//					   WHEN d.ITEM_ID IS NOT NULL THEN 1
//					   ELSE 0
//					END AS HAS_DETAILS
//		     FROM ITEM i LEFT JOIN ITEM_DETAILS d
//			 ON i.ID = d.ITEM_ID
//					""";
			
			preparedStatement = connection.prepareStatement(query);
			
			ResultSet resultSet = preparedStatement.executeQuery(query);
			
			Item item = null;
			while(resultSet.next()) {
				  item = new Item(
						resultSet.getInt("ID"),
						resultSet.getString("NAME"),
						resultSet.getDouble("PRICE"),
						resultSet.getInt("TOTAL_NUMBER")
				);
				  
		     item.setHasDetails(resultSet.getInt("HAS_DETAILS") == 1);  // that meaning if the current item that selected have HAS_DETAILS with 1 so it's true so meaning it have a row of item_details
		     
			 items.add(item);
			 
			}
			 return items;
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
	public Item selectItemById(Integer id) throws NamingException, SQLException {
		Connection connection = null; 
		PreparedStatement preparedStatement = null;
		try {
			connection = DBConfig.getConnection();
			String query = "SELECT * FROM ITEM WHERE ID = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
	// here we do if-else instead of while loop because the resultSet here is only have one row because I want to select rows that id = ? , and the id is primaryKey ,So it is unique and not-duplicated
			Item item = null;
			if (resultSet.next()) {  
				item = new Item(
						resultSet.getInt("ID"),
						resultSet.getString("NAME"),
						resultSet.getDouble("PRICE"),
						resultSet.getInt("TOTAL_NUMBER")
				);
			}
			 return item;
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
	public void saveItem(Item item) throws NamingException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBConfig.getConnection();
			String query = "INSERT INTO ITEM (NAME, PRICE, TOTAL_NUMBER) VALUES (?,?,?)";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, item.getName());
			preparedStatement.setDouble(2,item.getPrice());
			preparedStatement.setDouble(3,item.getTotalNumber());
			
			preparedStatement.executeUpdate();
			
		}  finally {
			if (Objects.nonNull(connection)) {
				connection.close();
			}
			
			if(preparedStatement != null) {
		        preparedStatement.close();
		    }
		}
	}

	
	@Override
	public void updateItem(Item item) throws NamingException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBConfig.getConnection();
			String query = "UPDATE ITEM SET NAME = ?, PRICE = ?, TOTAL_NUMBER = ? WHERE id = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, item.getName());
			preparedStatement.setDouble(2,item.getPrice());
			preparedStatement.setDouble(3,item.getTotalNumber());
			preparedStatement.setDouble(4,item.getId());
			
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
	public void deleteItem(Integer id) throws NamingException, SQLException {
		 Connection connection = null;
		 PreparedStatement preparedStatement = null;
		
		 try {
			connection = DBConfig.getConnection();
			
			String query = "DELETE FROM ITEM WHERE ID = ?";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1,id);
			
			preparedStatement.executeUpdate();  // this return the number of rows that is effected with the query
			
			// return rowsAffected > 0;  // so here if number > 0 that mean there is already rows deleted that is matching with the specific id
			
		} finally {
			if (Objects.nonNull(connection)) {
				connection.close();
			}
			
			if(preparedStatement != null) {
		        preparedStatement.close();
		    }
		}
		
	}

}

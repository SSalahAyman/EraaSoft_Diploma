package repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
	public List<Item> getAllItems() {
		Connection connection = null; 
		Statement statement = null ;
		List<Item> items = new ArrayList();
		try {
			connection = DBConfig.getConnection();
			statement = connection.createStatement();
			String query = "SELECT * FROM ITEM";
			ResultSet resultSet = statement.executeQuery(query);
			
			Item item = null;
			while(resultSet.next()) {
				  item = new Item(
						resultSet.getInt("ID"),
						resultSet.getString("NAME"),
						resultSet.getDouble("PRICE"),
						resultSet.getInt("TOTAL_NUMBER")
				);
			 items.add(item);
			}
			 return items;
		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
		} finally {
			if (Objects.nonNull(connection)) {
				try {
					connection.close();
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		 return null;   // when the function return this null is mean that is problem appear here after executing the catch
	}

	@Override
	public Item selectItemById(Integer id) {
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
		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
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
		 return null;   // when the function return this null is mean that is problem appear here after executing the catch
	}

	@Override
	public boolean saveItem(Item item) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBConfig.getConnection();
			String query = "INSERT INTO ITEM (NAME, PRICE, TOTAL_NUMBER) VALUES (?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, item.getName());
			preparedStatement.setDouble(2,item.getPrice());
			preparedStatement.setDouble(3,item.getTotalNumber());
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected == 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
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

	@Override
	public boolean updateItem(Item item) {
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
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
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

	@Override
	public boolean deleteItem(Integer id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		 try {
			connection = DBConfig.getConnection();
			
			String query = "DELETE FROM ITEM WHERE ID = ?";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1,id);
			
			int rowsAffected = preparedStatement.executeUpdate();  // this return the number of rows that is effected with the query
			
			return rowsAffected > 0;  // so here if number > 0 that mean there is already rows deleted that is matching with the specific id
			
		} catch (Exception e) {
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

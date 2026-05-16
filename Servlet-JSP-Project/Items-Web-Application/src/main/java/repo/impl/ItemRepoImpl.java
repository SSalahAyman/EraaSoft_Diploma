package repo.impl;

import java.sql.Connection;
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
			
			while(resultSet.next()) {
				Item item = new Item(
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
	public ResultSet selectItemById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItem(Integer id) {
		Connection connection = null;
		Statement statement = null;
		
		 try {
			connection = DBConfig.getConnection();
			String query = "DELETE FROM ITEM WHERE ID = " + id;
			statement = connection.createStatement();
			statement.execute(query);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
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
		return false;
	}

}

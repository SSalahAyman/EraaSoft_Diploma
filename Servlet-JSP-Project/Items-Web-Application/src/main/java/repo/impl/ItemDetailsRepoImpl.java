package repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import javax.naming.NamingException;

import database.DBConfig;
import model.ItemDetails;
import repo.ItemDetailsRepo;

public class ItemDetailsRepoImpl implements ItemDetailsRepo {

	@Override
	public ItemDetails getItemDetailsByItemId(Integer itemId) throws NamingException, SQLException  {
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try{
			
			connection = DBConfig.getConnection();
			
			String query = "SELECT * FROM ITEM_DETAILS WHERE ITEM_ID = ?";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, itemId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			ItemDetails itemDetails = null;
			if(resultSet.next()) {
				
				itemDetails= new ItemDetails(
						resultSet.getInt("ITEM_ID"),
						resultSet.getString("DESCRIPTION"),
						resultSet.getString("COLOR"),
						resultSet.getDouble("WEIGHT"),
						resultSet.getString("BRAND"),
						resultSet.getInt("ID")
				);
			}
			
			return itemDetails;
			
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
	public void addItemDetails(ItemDetails itemDetails) throws NamingException, SQLException {
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try{
			
			connection = DBConfig.getConnection();
			
			String query = "INSERT INTO ITEM_DETAILS (ITEM_ID , DESCRIPTION, COLOR , WEIGHT , BRAND ) VALUES (?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, itemDetails.getItemId());
			preparedStatement.setString(2, itemDetails.getDescription());
			preparedStatement.setString(3, itemDetails.getColor());
			preparedStatement.setDouble(4, itemDetails.getWeight());
			preparedStatement.setString(5, itemDetails.getBrand());
			
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
	public void updateItemDetails(ItemDetails itemDetails) throws NamingException, SQLException {
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try{
			
			connection = DBConfig.getConnection();
			
			String query = "UPDATE ITEM_DETAILS SET DESCRIPTION = ?, COLOR = ?, WEIGHT = ?, BRAND = ? WHERE ITEM_ID = ?";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, itemDetails.getDescription());
			preparedStatement.setString(2, itemDetails.getColor());
			preparedStatement.setDouble(3, itemDetails.getWeight());
			preparedStatement.setString(4, itemDetails.getBrand());
			preparedStatement.setInt(5, itemDetails.getItemId());
			
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
	public void deleteItemDetailsByItemId(Integer itemId) throws NamingException, SQLException {
		
		Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    try {

	        connection = DBConfig.getConnection();

	        String query = "DELETE FROM ITEM_DETAILS WHERE ITEM_ID = ?";

	        preparedStatement = connection.prepareStatement(query);

	        preparedStatement.setInt(1, itemId);

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

}

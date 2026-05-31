package repo;

import java.sql.SQLException;

import javax.naming.NamingException;

import model.ItemDetails;

public interface ItemDetailsRepo {

	ItemDetails getItemDetailsByItemId(Integer itemId) throws NamingException,SQLException;

    void addItemDetails(ItemDetails itemDetails) throws NamingException,SQLException;

    void updateItemDetails(ItemDetails itemDetails) throws NamingException, SQLException;
    
    void deleteItemDetailsByItemId(Integer itemId) throws NamingException, SQLException;
	
}

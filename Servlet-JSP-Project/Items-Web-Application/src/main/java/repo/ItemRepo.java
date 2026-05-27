package repo;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import model.Item;

public interface ItemRepo {
	
	List<Item> getAllItems() throws NamingException, SQLException; 
	
	Item selectItemById(Integer id) throws NamingException, SQLException;
	
	void saveItem(Item item) throws NamingException, SQLException;
	
	void updateItem(Item item) throws NamingException, SQLException;
	
	void deleteItem(Integer id) throws NamingException, SQLException;  
	
}

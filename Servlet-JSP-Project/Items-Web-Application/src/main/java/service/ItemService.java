package service;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import model.Item;

/* this interface class is consists of services functions that help ItemController in process of handle the specific request that is coming to it 
 * with each case of actions that user doing it On item controller >>> must uses of one these services functions to help controller to handle the request
 * such as action="add-item" uses the saveItem() to help him in the adding item in the database
 */
public interface ItemService {
	
	List<Item> getAllItems() throws NamingException, SQLException;
	
	Item selectItem(Integer id) throws NamingException, SQLException;
	
	void saveItem(Item item) throws NamingException, SQLException;
	
	void updateitem(Item item) throws NamingException, SQLException;
	
	void deleteItem(Integer id) throws NamingException, SQLException;  

}

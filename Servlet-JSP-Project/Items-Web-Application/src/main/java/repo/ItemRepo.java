package repo;

import java.sql.ResultSet;
import java.util.List;

import model.Item;

public interface ItemRepo {
	
	List<Item> getAllItems(); //
	
	ResultSet selectItemById(long id);
	
	void saveItem(Item item);
	
	boolean updateItem(Item item);
	
	boolean deleteItem(Integer id);  //
	
}

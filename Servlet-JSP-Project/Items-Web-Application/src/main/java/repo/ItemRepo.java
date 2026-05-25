package repo;

import java.util.List;

import model.Item;

public interface ItemRepo {
	
	List<Item> getAllItems(); 
	
	Item selectItemById(Integer id);
	
	boolean saveItem(Item item);
	
	boolean updateItem(Item item);
	
	boolean deleteItem(Integer id);  
	
}

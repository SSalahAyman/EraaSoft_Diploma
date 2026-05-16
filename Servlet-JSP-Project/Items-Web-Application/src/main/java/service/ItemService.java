package service;

import java.util.List;

import model.Item;

/* this interface class is consists of services functions that help ItemController in process of handle the specific request that is coming to it 
 * with each case of actions that user doing it On item controller >>> must uses of one these services functions to help controller to handle the request
 * such as action="add-item" uses the saveItem() to help him in the adding item in the database
 */
public interface ItemService {
	
	List<Item> getAllItems();
	
	Item selectItem(Long id);
	
	boolean saveItem(Item item);
	
	boolean updateitem(Item item);
	
	boolean deleteItem(Item item);  //

}

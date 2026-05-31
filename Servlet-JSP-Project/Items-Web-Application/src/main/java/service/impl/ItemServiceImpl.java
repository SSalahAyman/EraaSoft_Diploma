package service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.sql.DataSource;

import exceptions.InvalidItemDataException;
import exceptions.InvalidItemNameFormatException;
import exceptions.ItemNotFoundException;
import exceptions.MissingMandatoryField;
import model.Item;
import repo.ItemDetailsRepo;
import repo.ItemRepo;
import repo.impl.ItemDetailsRepoImpl;
import repo.impl.ItemRepoImpl;
import service.ItemService;
import util.ItemInputValidator;

public class ItemServiceImpl implements ItemService {
	
//	@Resource
//	(name = "jdbc/item")
//	private DataSource dataSource;
	
	ItemRepo itemRepo = new ItemRepoImpl();
	
	ItemDetailsRepo itemDetailsRepo = new ItemDetailsRepoImpl();
	
	@Override
	public List<Item> getAllItems() throws NamingException, SQLException {
		
		List<Item> items = itemRepo.getAllItems();
		
		return items;
		
	}

	@Override
	public Item selectItem(Integer id) throws ItemNotFoundException , NamingException, SQLException {
		
		Item item = itemRepo.selectItemById(id);
		
		if (Objects.isNull(item)) {
			throw new ItemNotFoundException();
		}
		
		return item;
		
	}

	@Override
	public void saveItem(Item item) throws MissingMandatoryField , InvalidItemNameFormatException , InvalidItemDataException, NamingException, SQLException   {
		
		ItemInputValidator.validateAddItemInputs(item);
		
		 itemRepo.saveItem(item);
		
	}

	@Override
	public void updateitem(Item item) throws MissingMandatoryField , InvalidItemNameFormatException , InvalidItemDataException, NamingException, SQLException {
		
		ItemInputValidator.validateUpdateItemInputs(item);
		
		 itemRepo.updateItem(item);
		 
	}

	@Override
	public void deleteItem(Integer id) throws NamingException, SQLException {
		
		/*
	     * First delete the item's details (if they exist)
	     * to avoid Foreign Key Constraint violations.
	     *
	     * If no details exist for this item,
	     * the DELETE query simply affects 0 rows
	     * and no exception will be thrown.
	     */
		itemDetailsRepo.deleteItemDetailsByItemId(id);
		
		/*
	     * After deleting the related details,
	     * delete the main item record.
	     */
		itemRepo.deleteItem(id);
		
	}

}

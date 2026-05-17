package service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.sql.DataSource;

import model.Item;
import repo.ItemRepo;
import repo.impl.ItemRepoImpl;
import service.ItemService;
import util.InputValidator;

public class ItemServiceImpl implements ItemService {
	
//	@Resource
//	(name = "jdbc/item")
//	private DataSource dataSource;
	
	ItemRepo itemRepo = new ItemRepoImpl();
	
	@Override
	public List<Item> getAllItems() {
		List<Item> items = itemRepo.getAllItems();
		return items;
	}

	@Override
	public Item selectItem(Integer id) {
		Item item = itemRepo.selectItemById(id);
		return item;
	}

	@Override
	public boolean saveItem(Item item) {
		boolean isValidInputs = InputValidator.isValidateAddItemInputs(item);
		
		if(!isValidInputs) {
			return false;
		}
		return itemRepo.saveItem(item);
		
	}

	@Override
	public boolean updateitem(Item item) {
		boolean isValidInputs = InputValidator.isValidateUpdateitemInputs(item);
		
		if(!isValidInputs) {
			return false;
		}
		return itemRepo.updateItem(item);
	}

	@Override
	public boolean deleteItem(Integer id) {
		return itemRepo.deleteItem(id);
	}

}

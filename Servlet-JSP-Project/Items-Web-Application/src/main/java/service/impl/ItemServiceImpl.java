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
	public Item selectItem(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateitem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItem(Integer id) {
		boolean isItemDeleted = itemRepo.deleteItem(id);
		return isItemDeleted;
	}

}

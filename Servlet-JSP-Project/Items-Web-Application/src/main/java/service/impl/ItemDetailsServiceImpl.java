package service.impl;

import java.sql.SQLException;
import java.util.Objects;

import javax.naming.NamingException;

import exceptions.InvalidItemDetailsException;
import exceptions.ItemDetailsAlreadyExistsException;
import exceptions.ItemDetailsNotFoundException;
import model.ItemDetails;
import repo.ItemDetailsRepo;
import repo.impl.ItemDetailsRepoImpl;
import service.ItemDetailsService;
import util.ItemDetailsInputValidator;

public class ItemDetailsServiceImpl implements ItemDetailsService {
	
	private ItemDetailsRepo itemDetailsRepo = new ItemDetailsRepoImpl();

	@Override
	public ItemDetails getItemDetailsByItemId(Integer itemId) throws NamingException, SQLException {
		
		ItemDetails itemDetails = itemDetailsRepo.getItemDetailsByItemId(itemId);
		
		if (Objects.isNull(itemDetails)) {
			
			throw new ItemDetailsNotFoundException();
			
		}
		
		return itemDetails;
	}

	@Override
	public void addItemDetails(ItemDetails itemDetails) throws InvalidItemDetailsException, NamingException, SQLException {
		
		ItemDetailsInputValidator.validateAddItemDetailsInputs(itemDetails);
		
		ItemDetails existingDetails = itemDetailsRepo.getItemDetailsByItemId(itemDetails.getItemId());
		
		if (Objects.nonNull(existingDetails)) {
			
			throw new ItemDetailsAlreadyExistsException();
		}
		
		itemDetailsRepo.addItemDetails(itemDetails);
		
	}

	@Override
	public void updateItemDetails(ItemDetails itemDetails) throws InvalidItemDetailsException , NamingException, SQLException {
		
		ItemDetailsInputValidator.validateUpdateItemDetailsInputs(itemDetails);
		
		ItemDetails existingDetails = itemDetailsRepo.getItemDetailsByItemId(itemDetails.getItemId());
		
		if (Objects.isNull(existingDetails)) {
					
			throw new ItemDetailsNotFoundException();
		}
		
		itemDetailsRepo.updateItemDetails(itemDetails);
		
	}

}

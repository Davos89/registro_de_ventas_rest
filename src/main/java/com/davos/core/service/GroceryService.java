package com.davos.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davos.core.dto.GroceryDTO;

@Service
public interface GroceryService {
	
	/**
	 * 
	 * @return a list of all groceries in database like instances of {@code GroceryDTO} 
	 */
	public List<GroceryDTO> getAll();
	
	/**
	 * 
	 * @param name the name of the {@code GroceryDTO}
	 * @return the {@code Customer} who matches with the name
	 */
	public GroceryDTO getGrocery(String name);

	/**
	 * 
	 * @param id the identifier of the {@code GroceryDTO}
	 * @return the {@code GroceryDTO} who matches with the identifier
	 */
	public GroceryDTO getGrocery(int id);

	/**
	 * 
	 * Creates or updates an existing record in the grocery table from the database
	 * 
	 * @param groceryDTO the {@code GroceryDTO} to create or update in the database
	 */
	public void createOrUpdate(GroceryDTO groceryDTO);

	/**
	 * 
	 * Deletes a record from the customer table from the database
	 * 
	 * @param id the identifier of the {@code Customer} to delete
	 */
	public void delete(int id);


}

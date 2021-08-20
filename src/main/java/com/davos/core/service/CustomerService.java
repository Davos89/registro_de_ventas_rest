package com.davos.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davos.core.dto.CustomerDTO;

@Service
public interface CustomerService {

	/**
	 * 
	 * @return a list of all customers in database like instances of {@code CustomerDTO} 
	 */
	public List<CustomerDTO> getAll();

	/**
	 * 
	 * @param name the name of the {@code Customer}
	 * @return the {@code Customer} who matches with the name
	 */
	public CustomerDTO getCustomer(String name);

	/**
	 * 
	 * @param id the identifier of the {@code Customer}
	 * @return the {@code Customer} who matches with the identifier
	 */
	public CustomerDTO getCustomer(int id);

	/**
	 * 
	 * Creates or updates an existing record in the customer table from the database
	 * 
	 * @param customer the {@code Customer} to create or update in the database
	 */
	public void createOrUpdate(CustomerDTO customer);

	/**
	 * 
	 * Deletes a record from the customer table from the database
	 * 
	 * @param id the identifier of the {@code Customer} to delete
	 */
	public void delete(int id);

	/**
	 * 
	 * @param year the year chosen to find the best client
	 * @return	the name of the best customer and the sum sold to him
	 */
	public String bestCustomer(int year);
}

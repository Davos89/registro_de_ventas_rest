package com.davos.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davos.core.dto.SellerDTO;

@Service
public interface SellerService {
	
	/**
	 * 
	 * @return a list of all sellers in database like instances of {@code SellerDTO} 
	 */
	public List<SellerDTO> getAll();
	
	/**
	 * 
	 * @param name the name of the {@code SellerDTO}
	 * @return the {@code SellerDTO} who matches with the name
	 */
	public SellerDTO getSeller(String name);

	/**
	 * 
	 * @param id the identifier of the {@code SellerDTO}
	 * @return the {@code SellerDTO} who matches with the identifier
	 */
	public SellerDTO getSeller(int id);

	/**
	 * 
	 * Creates or updates an existing record in the seller table from the database
	 * 
	 * @param groceryDTO the {@code SellerDTO} to create or update in the database
	 */
	public void createOrUpdate(SellerDTO sellerDTO);

	/**
	 * 
	 * Deletes a record from the seller table from the database
	 * 
	 * @param id the identifier of the {@code Seller} to delete
	 */
	public void delete(int id);

}

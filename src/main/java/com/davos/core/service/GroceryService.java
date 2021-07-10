package com.davos.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davos.core.dto.GroceryDTO;
import com.davos.core.entity.Grocery;

@Service
public interface GroceryService {
	
	public List<GroceryDTO> getAll();
	
	public GroceryDTO getByName(String name);

	public GroceryDTO getById(int id);

	public boolean createOrUpdate(Grocery grocery);

	public boolean delete(int id);


}

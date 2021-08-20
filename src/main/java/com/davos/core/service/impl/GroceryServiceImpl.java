package com.davos.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davos.core.entity.Grocery;
import com.davos.core.entity.Sale;
import com.davos.core.http_errors.NullEntityException;
import com.davos.core.http_errors.RecordNotFoundException;
import com.davos.core.dto.GroceryDTO;
import com.davos.core.repository.GroceryRepository;
import com.davos.core.service.GroceryService;

@Service
public class GroceryServiceImpl implements GroceryService {

	@Autowired
	private GroceryRepository groceryRepository;

	

	@Override
	public List<GroceryDTO> getAll() {

		List<Grocery> groceries = groceryRepository.findAll();
		List<GroceryDTO> groceryDTOs = new ArrayList<>();

		for (Grocery grocery : groceries) {
			groceryDTOs.add(new GroceryDTO(grocery));
		}

		return groceryDTOs;

	}

	@Override
	public GroceryDTO getGrocery(String name) {
		return new GroceryDTO(groceryRepository.findByName(name));
	}

	@Override
	public GroceryDTO getGrocery(int id) {
		return new GroceryDTO(groceryRepository.findById(id));
	}

	public void createOrUpdate(GroceryDTO groceryDTO) {

		Grocery grocery = groceryDTO.toGrocery();
		
		if (grocery == null) {
			throw new NullEntityException("Entity of type '"+ Sale.class +"' cannot be saved or updated because is null");
		}
		
		groceryRepository.save(grocery);

	}

	@Override
	public void delete(int id) {
		Grocery grocery = groceryRepository.findById(id);
		
		if (grocery == null) {
			throw new RecordNotFoundException("Entity of type 'Grocery.class' cannot be deleted because doesn´t exists");
		}
		
		groceryRepository.delete(grocery);

	}
}

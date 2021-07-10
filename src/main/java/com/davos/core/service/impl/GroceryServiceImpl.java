package com.davos.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davos.core.entity.Grocery;
import com.davos.core.mapper.GroceryMapper;
import com.davos.core.dto.GroceryDTO;
import com.davos.core.repository.GroceryRepository;
import com.davos.core.service.GroceryService;

@Service
public class GroceryServiceImpl implements GroceryService{

	@Autowired
	private GroceryRepository groceryRepository;
	
	@Autowired
	private GroceryMapper mapper;
	
	public List<GroceryDTO> getAll() {
		
		List<Grocery> groceries = groceryRepository.findAll();
		List<GroceryDTO> groceryDTOs = new ArrayList<>();
		
		for (Grocery grocery : groceries) {
			groceryDTOs.add(mapper.groceryToGroceryDTO(grocery));
		}
		
		
		return groceryDTOs;
		
		
	}
	
	public GroceryDTO getByName(String name) {
		return mapper.groceryToGroceryDTO(groceryRepository.findByName(name));
	}
	
	public GroceryDTO getById(int id) {
		return mapper.groceryToGroceryDTO(groceryRepository.findById(id));
	}
	
	public boolean createOrUpdate(Grocery grocery) {
		try {
			groceryRepository.save(grocery);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(int id) {
		try {
			Grocery grocery = groceryRepository.findById(id);
			groceryRepository.delete(grocery);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

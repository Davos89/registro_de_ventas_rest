package com.davos.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.davos.core.dto.GroceryDTO;
import com.davos.core.entity.Grocery;

@Mapper(componentModel = "spring")
public interface GroceryMapper {
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	Grocery groceryDTOToGrocery(GroceryDTO groceryDTO);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	GroceryDTO groceryToGroceryDTO(Grocery grocery);

}

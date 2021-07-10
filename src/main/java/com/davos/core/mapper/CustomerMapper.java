package com.davos.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.davos.core.dto.CustomerDTO;
import com.davos.core.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	CustomerDTO customerToCustomerDTO(Customer customer);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	Customer customerDTOToCustomer(CustomerDTO customerDTO);

}

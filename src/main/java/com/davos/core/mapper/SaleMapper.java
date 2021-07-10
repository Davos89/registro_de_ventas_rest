package com.davos.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.davos.core.dto.SaleDTO;
import com.davos.core.entity.Customer;
import com.davos.core.entity.Grocery;
import com.davos.core.entity.Sale;
import com.davos.core.entity.Seller;
import com.davos.core.repository.CustomerRepository;
import com.davos.core.repository.GroceryRepository;
import com.davos.core.repository.SellerRepository;

@Mapper(componentModel = "spring")
public abstract class SaleMapper {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	GroceryRepository groceryRepository;
	
	@Autowired
	SellerRepository sellerRepository;
	
	@Mapping(source = "customer.id", target = "idCustomer")
	@Mapping(source = "grocery.id", target = "idGrocery")
	@Mapping(source = "seller.id", target = "idSeller")
	public abstract SaleDTO saleToSaleDTO(Sale sale);
	
	
	@Mapping(source = "idCustomer", target = "customer", qualifiedByName = "fromIdToCustomer")
	@Mapping(source = "idGrocery", target = "grocery", qualifiedByName = "fromIdToGrocery")
	@Mapping(source = "idSeller", target = "seller", qualifiedByName = "fromIdToSeller")
	public abstract Sale saleDTOToSale(SaleDTO saleDTO);
	
	
	
	@Named("fromIdToCustomer")
	public Customer fromIdToCustomer(int id) {
		return customerRepository.findById(id);
	}
	
	@Named("fromIdToGrocery")
	public Grocery fromIdToGrocery(int id) {
		return groceryRepository.findById(id);
	}
	
	@Named("fromIdToSeller")
	public Seller fromIdToSeller(int id) {
		return sellerRepository.findById(id);
	}
}

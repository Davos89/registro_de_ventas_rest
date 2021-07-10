package com.davos.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davos.core.dto.CustomerDTO;
import com.davos.core.entity.Customer;

@Service
public interface CustomerService {
	
	

	public List<CustomerDTO> getAll();
	
	public CustomerDTO getByName(String name);

	public CustomerDTO getById(int id);

	public boolean createOrUpdate(Customer customer);

	public boolean delete(int id);

	public String bestCustomer(int anio);
}

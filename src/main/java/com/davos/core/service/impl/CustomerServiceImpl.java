package com.davos.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davos.core.dto.CustomerDTO;
import com.davos.core.entity.Customer;
import com.davos.core.entity.Sale;
import com.davos.core.http_errors.NullEntityException;
import com.davos.core.http_errors.RecordNotFoundException;
import com.davos.core.repository.CustomerRepository;
import com.davos.core.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;


	public List<CustomerDTO> getAll() {

		List<Customer> customers = customerRepository.findAll();
		List<CustomerDTO> customerDTOs = new ArrayList<>();

		for (Customer customer : customers) {
			customerDTOs.add(new CustomerDTO(customer));
		}

		return customerDTOs;

	}

	public CustomerDTO getCustomer(String name) {
		return new CustomerDTO(customerRepository.findByName(name));
	}

	public CustomerDTO getCustomer(int id) {
		return new CustomerDTO(customerRepository.findById(id));
	}

	public void createOrUpdate(CustomerDTO customerDTO) {

		Customer customer = customerDTO.toCustomer();
		
		if (customer == null) {
			throw new NullEntityException("Entity of type 'Customer.class' cannot be saved or updated because is null");
		}
		
		customerRepository.save(customer);
		

	}

	public void delete(int id) {

		Customer customer = customerRepository.findById(id);
		
		if (customer == null) {
			throw new RecordNotFoundException("Entity of type 'Customer.class' cannot be deleted because doesn´t exists");
		}
		
		customerRepository.delete(customer);

	}

	public String bestCustomer(int year) {

		String bestCustomer = "";
		int salesBestCustomer = 0;

		List<Customer> customers = customerRepository.findAll();

		for (Customer customer : customers) {
			List<Sale> sales = customer.getSales();
			int sold = 0;
			for (Sale sale : sales) {
				if (sale.getDate().getYear() == year) {
					sold += sale.getUnitPrice() * sale.getUnits();
				}
			}
			if (sold > salesBestCustomer) {
				salesBestCustomer = sold;
				bestCustomer = customer.getName() + " $" + salesBestCustomer;
			}

		}

		return bestCustomer;
	}
}

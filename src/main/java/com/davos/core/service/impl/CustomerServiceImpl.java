package com.davos.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davos.core.dto.CustomerDTO;
import com.davos.core.entity.Customer;
import com.davos.core.entity.Sale;
import com.davos.core.mapper.CustomerMapper;
import com.davos.core.repository.CustomerRepository;
import com.davos.core.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerMapper mapper;

	public List<CustomerDTO> getAll() {

		List<Customer> customers = customerRepository.findAll();
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		
		for (Customer customer : customers) {
			customerDTOs.add(mapper.customerToCustomerDTO(customer));
		}

		return customerDTOs;

	}

	public CustomerDTO getByName(String name) {
		return mapper.customerToCustomerDTO(customerRepository.findByName(name));
	}

	public CustomerDTO getById(int id) {
		return mapper.customerToCustomerDTO(customerRepository.findById(id));
	}

	public boolean createOrUpdate(Customer customer) {
		try {
			customerRepository.save(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			Customer customer = customerRepository.findById(id);
			customerRepository.delete(customer);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String bestCustomer(int anio) {

		String bestCustomer = "";
		int salesBestCustomer = 0;

		List<Customer> customers = customerRepository.findAll();

		for (Customer customer : customers) {
			List<Sale> sales = customer.getSales();
			int sold = 0;
			for (Sale sale : sales) {
				if (sale.getDate().getYear() == anio) {
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

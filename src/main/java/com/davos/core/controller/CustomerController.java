package com.davos.core.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davos.core.dto.CustomerDTO;
import com.davos.core.service.CustomerService;


@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
	
	@Autowired
	CustomerService service;

	@GetMapping("/{year}")
	public String bestCustomer(@PathVariable("year") int year) {
		
		return service.bestCustomer(year);
	}
	
	@PutMapping
	public void updateCustomer(@RequestBody @Valid CustomerDTO customer) {
		service.createOrUpdate(customer);
	}
	
	@PostMapping
	public void createCustomer(@RequestBody @Valid CustomerDTO customer) {
		service.createOrUpdate(customer);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}
	
	@GetMapping
	public List<CustomerDTO> getCustomers(){
		return service.getAll();
	}
	
	@GetMapping("/{name}")
	public CustomerDTO getByName(@PathVariable("name") String name){
		return service.getCustomer(name);
	}
	
	@GetMapping("/{id}")
	public CustomerDTO getById(@PathVariable("id") int id){
		return service.getCustomer(id);
	}
	
}

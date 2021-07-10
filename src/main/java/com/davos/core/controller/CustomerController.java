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

import com.davos.core.entity.Customer;
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
	
	@PutMapping()
	public boolean updateCustomer(@RequestBody @Valid Customer customer) {
		return service.createOrUpdate(customer);
	}
	
	@PostMapping()
	public boolean createCustomer(@RequestBody @Valid Customer customer) {
		return service.createOrUpdate(customer);
	}
	
	@DeleteMapping("/{id}")
	public boolean borrarNota(@PathVariable("id") int id) {
		return service.delete(id);
	}
	
	@GetMapping()
	public List<CustomerDTO> obtenerClientes(){
		return service.getAll();
	}
	
	@GetMapping("/{name}")
	public CustomerDTO obtenerClientePorNombre(@PathVariable("name") String name){
		return service.getByName(name);
	}
	
	@GetMapping("/{id}")
	public CustomerDTO obtenerClientePorId(@PathVariable("id") int id){
		return service.getById(id);
	}
	
}

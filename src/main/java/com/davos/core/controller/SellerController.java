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

import com.davos.core.dto.SellerDTO;
import com.davos.core.service.SellerService;


@RestController
@RequestMapping("/v1/seller")
public class SellerController {
	
	@Autowired
	SellerService service;

	@PutMapping()
	public void updateSeller(@RequestBody @Valid SellerDTO seller) {
		service.createOrUpdate(seller);
	}
	
	@PostMapping()
	public void createSeller(@RequestBody @Valid SellerDTO seller) {
		service.createOrUpdate(seller);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}
	
	@GetMapping()
	public List<SellerDTO> getAllSellers(){
		return service.getAll();
	}
	
	@GetMapping("/byName/{name}")
	public SellerDTO sellerByName(@PathVariable("name") String name){
		return service.getSeller(name);
	}
	
	@GetMapping("/byId/{id}")
	public SellerDTO sellerById(@PathVariable("id") int id){
		return service.getSeller(id);
	}
	
}

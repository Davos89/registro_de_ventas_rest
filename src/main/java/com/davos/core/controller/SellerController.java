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
import com.davos.core.entity.Seller;
import com.davos.core.service.SellerService;
import com.davos.core.service.impl.SellerServiceImpl;


@RestController
@RequestMapping("/v1/seller")
public class SellerController {
	
	@Autowired
	SellerService service;

	@PutMapping()
	public boolean updateSeller(@RequestBody @Valid Seller seller) {
		return service.createOrUpdate(seller);
	}
	
	@PostMapping()
	public boolean actualizarNota(@RequestBody @Valid Seller seller) {
		return service.createOrUpdate(seller);
	}
	
	@DeleteMapping("/{id}")
	public boolean borrarNota(@PathVariable("id") int id) {
		return service.delete(id);
	}
	
	@GetMapping()
	public List<SellerDTO> obtenerVendedores(){
		return service.getAll();
	}
	
	@GetMapping("/{name}")
	public SellerDTO sellerByName(@PathVariable("name") String name){
		return service.getByName(name);
	}
	
	@GetMapping("/{id}")
	public SellerDTO sellerById(@PathVariable("id") int id){
		return service.getById(id);
	}
	
}

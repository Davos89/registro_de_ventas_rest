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

import com.davos.core.entity.Grocery;
import com.davos.core.dto.GroceryDTO;
import com.davos.core.service.GroceryService;


@RestController
@RequestMapping("/v1/grocery")
public class GroceryController {
	
	@Autowired
	private GroceryService service;

	@PutMapping()
	public boolean updateGrocery(@RequestBody @Valid Grocery grocery) {
		return service.createOrUpdate(grocery);
	}
	
	@PostMapping()
	public boolean actualizarNota(@RequestBody @Valid Grocery grocery) {
		return service.createOrUpdate(grocery);
	}
	
	@DeleteMapping("/{id}")
	public boolean borrarNota(@PathVariable("id") int id) {
		return service.delete(id);
	}
	
	@GetMapping()
	public List<GroceryDTO> obtenerMercaderias(){
		return service.getAll();
	}
	
	@GetMapping("/{name}")
	public GroceryDTO obtenerMercaderiaPorNombre(@PathVariable("name") String name){
		return service.getByName(name);
	}
	
	@GetMapping("/{id}")
	public GroceryDTO obtenerMercaderiaPorId(@PathVariable("id") int id){
		return service.getById(id);
	}
	
}

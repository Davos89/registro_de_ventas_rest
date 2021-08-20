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

import com.davos.core.dto.GroceryDTO;
import com.davos.core.service.GroceryService;


@RestController
@RequestMapping("/v1/grocery")
public class GroceryController {
	
	@Autowired
	private GroceryService service;

	@PutMapping()
	public void updateGrocery(@RequestBody @Valid GroceryDTO groceryDTO) {
		service.createOrUpdate(groceryDTO);
	}
	
	@PostMapping()
	public void actualizarNota(@RequestBody @Valid GroceryDTO groceryDTO) {
		service.createOrUpdate(groceryDTO);
	}
	
	@DeleteMapping("/{id}")
	public void borrarNota(@PathVariable("id") int id) {
		service.delete(id);
	}
	
	@GetMapping()
	public List<GroceryDTO> obtenerMercaderias(){
		return service.getAll();
	}
	
	@GetMapping("/{name}")
	public GroceryDTO obtenerMercaderiaPorNombre(@PathVariable("name") String name){
		return service.getGrocery(name);
	}
	
	@GetMapping("/{id}")
	public GroceryDTO obtenerMercaderiaPorId(@PathVariable("id") int id){
		return service.getGrocery(id);
	}
	
}

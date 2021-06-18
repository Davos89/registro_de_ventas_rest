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

import com.davos.core.entity.Vendedor;
import com.davos.core.model.MVendedor;
import com.davos.core.service.VendedorService;


@RestController
@RequestMapping("/v1")
public class VendedorController {
	
	@Autowired
	VendedorService service;

	@PutMapping("/actualizaVendedor")
	public boolean actualizarVendedor(@RequestBody @Valid Vendedor vendedor) {
		return service.crearOActualizar(vendedor);
	}
	
	@PostMapping("/creaVendedor")
	public boolean actualizarNota(@RequestBody @Valid Vendedor vendedor) {
		return service.crearOActualizar(vendedor);
	}
	
	@DeleteMapping("/vendedorDel/{id}")
	public boolean borrarNota(@PathVariable("id") int id) {
		return service.borrar(id);
	}
	
	@GetMapping("/vendedores")
	public List<MVendedor> obtenerVendedores(){
		return service.obtener();
	}
	
	@GetMapping("/vendedorXNombre/{nombre}")
	public MVendedor obtenerVendedorPorNombre(@PathVariable("nombre") String nombre){
		return service.obtenerPorNombre(nombre);
	}
	
	@GetMapping("/vendedorXId/{id}")
	public MVendedor obtenerVendedorPorId(@PathVariable("id") int id){
		return service.obtenerPorId(id);
	}
	
}

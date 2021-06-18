package com.davos.core.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davos.core.entity.Cliente;
import com.davos.core.model.MCliente;
import com.davos.core.service.ClienteService;


@RestController
@RequestMapping("/v1")
public class ClienteController {
	
	@Autowired
	ClienteService service;

	@PutMapping("/actualizaCliente")
	public boolean actualizarCliente(@RequestBody @Valid Cliente cliente) {
		return service.crearOActualizar(cliente);
	}
	
	@PostMapping("/creaCliente")
	public boolean actualizarNota(@RequestBody @Valid Cliente cliente) {
		return service.crearOActualizar(cliente);
	}
	
	@DeleteMapping("/clienteDel/{id}")
	public boolean borrarNota(@PathVariable("id") int id) {
		return service.borrar(id);
	}
	
	@GetMapping("/clientes")
	public List<MCliente> obtenerClientes(){
		return service.obtener();
	}
	
	@GetMapping("/clienteXNombre/{nombre}")
	public MCliente obtenerClientePorNombre(@PathVariable("nombre") String nombre){
		return service.obtenerPorNombre(nombre);
	}
	
	@GetMapping("/clienteXId/{id}")
	public MCliente obtenerClientePorId(@PathVariable("id") int id){
		return service.obtenerPorId(id);
	}
	
}

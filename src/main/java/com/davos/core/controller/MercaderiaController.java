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

import com.davos.core.entity.Mercaderia;
import com.davos.core.model.MMercaderia;
import com.davos.core.service.MercaderiaService;


@RestController
@RequestMapping("/v1")
public class MercaderiaController {
	
	@Autowired
	MercaderiaService service;

	@PutMapping("/actualizaMercaderia")
	public boolean actualizarMercaderia(@RequestBody @Valid Mercaderia mercaderia) {
		return service.crearOActualizar(mercaderia);
	}
	
	@PostMapping("/creaMercaderia")
	public boolean actualizarNota(@RequestBody @Valid Mercaderia mercaderia) {
		return service.crearOActualizar(mercaderia);
	}
	
	@DeleteMapping("/mercaderiaDel/{id}")
	public boolean borrarNota(@PathVariable("id") int id) {
		return service.borrar(id);
	}
	
	@GetMapping("/mercaderias")
	public List<MMercaderia> obtenerMercaderias(){
		return service.obtener();
	}
	
	@GetMapping("/mercaderiaXNombre/{nombre}")
	public MMercaderia obtenerMercaderiaPorNombre(@PathVariable("nombre") String nombre){
		return service.obtenerPorNombre(nombre);
	}
	
	@GetMapping("/mercaderiaXId/{id}")
	public MMercaderia obtenerMercaderiaPorId(@PathVariable("id") int id){
		return service.obtenerPorId(id);
	}
	
}

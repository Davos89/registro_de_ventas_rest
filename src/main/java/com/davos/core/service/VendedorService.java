package com.davos.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davos.core.converter.Convertidor;
import com.davos.core.entity.Vendedor;
import com.davos.core.model.MVendedor;
import com.davos.core.repository.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private Convertidor convertidor;
	
	public List<MVendedor> obtener() {
		
		List<Vendedor> vendedores = vendedorRepository.findAll();
		
		return convertidor.convertirVendedors(vendedores);
		
	}
	
	public MVendedor obtenerPorNombre(String nombre) {
		return new MVendedor(vendedorRepository.findByNombre(nombre));
	}
	public MVendedor obtenerPorId(int id) {
		return new MVendedor(vendedorRepository.findById(id));
	}
	
	public boolean crearOActualizar(Vendedor vendedor) {
		try {
			vendedorRepository.save(vendedor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean borrar(int id) {
		try {
			Vendedor vendedor = vendedorRepository.findById(id);
			vendedorRepository.delete(vendedor);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

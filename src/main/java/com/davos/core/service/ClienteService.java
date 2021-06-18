package com.davos.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davos.core.converter.Convertidor;
import com.davos.core.entity.Cliente;
import com.davos.core.model.MCliente;
import com.davos.core.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private Convertidor convertidor;
	
	public List<MCliente> obtener() {
		
		List<Cliente> clientes = clienteRepository.findAll();
		
		return convertidor.convertirClientes(clientes);
		
	}
	
	public MCliente obtenerPorNombre(String nombre) {
		return new MCliente(clienteRepository.findByNombre(nombre));
	}
	public MCliente obtenerPorId(int id) {
		return new MCliente(clienteRepository.findById(id));
	}
	
	public boolean crearOActualizar(Cliente cliente) {
		try {
			clienteRepository.save(cliente);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean borrar(int id) {
		try {
			Cliente cliente = clienteRepository.findById(id);
			clienteRepository.delete(cliente);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

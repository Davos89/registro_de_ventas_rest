package com.davos.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davos.core.converter.Convertidor;
import com.davos.core.entity.Mercaderia;
import com.davos.core.model.MMercaderia;
import com.davos.core.repository.MercaderiaRepository;

@Service
public class MercaderiaService {

	@Autowired
	private MercaderiaRepository mercaderiaRepository;
	
	@Autowired
	private Convertidor convertidor;
	
	public List<MMercaderia> obtener() {
		
		List<Mercaderia> mercaderias = mercaderiaRepository.findAll();
		
		return convertidor.convertirMercaderias(mercaderias);
		
		
	}
	
	public MMercaderia obtenerPorNombre(String nombre) {
		return new MMercaderia(mercaderiaRepository.findByNombre(nombre));
	}
	
	public MMercaderia obtenerPorId(int id) {
		return new MMercaderia(mercaderiaRepository.findById(id));
	}
	
	public boolean crearOActualizar(Mercaderia mercaderia) {
		try {
			mercaderiaRepository.save(mercaderia);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean borrar(int id) {
		try {
			Mercaderia mercaderia = mercaderiaRepository.findById(id);
			mercaderiaRepository.delete(mercaderia);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

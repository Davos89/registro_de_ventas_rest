package com.davos.core.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davos.core.converter.Convertidor;
import com.davos.core.entity.Cliente;
import com.davos.core.entity.Mercaderia;
import com.davos.core.entity.Vendedor;
import com.davos.core.entity.Venta;
import com.davos.core.model.MCliente;
import com.davos.core.model.MVenta;
import com.davos.core.repository.VentaRepository;

@Service
public class VentaService {

	@Autowired
	private VentaRepository ventaRepository;

	@Autowired
	private Convertidor convertidor;

	public List<MVenta> obtenerPorCliente(Cliente cliente) {

		return convertidor.convertirVentas(ventaRepository.findByCliente(cliente));

	}

	public List<MVenta> obtenerPorFecha(LocalDate fecha) {

		return convertidor.convertirVentas(ventaRepository.findByFecha(fecha));

	}

	public List<MVenta> obtenerPorMercaderia(Mercaderia mercaderia) {

		return convertidor.convertirVentas(ventaRepository.findByMercaderia(mercaderia));

	}

	public List<MVenta> obtenerPorVendedor(Vendedor vendedor) {

		return convertidor.convertirVentas(ventaRepository.findByVendedor(vendedor));

	}

	public MVenta obtenerPorId(int id) {

		return new MVenta(ventaRepository.findById(id));

	}

	public MVenta obtenerPorFechaYCliente(LocalDate fecha, Cliente cliente) {

		return new MVenta(ventaRepository.findByFechaAndCliente(fecha, cliente));

	}
	
	public List<MVenta> obtener() {
		return convertidor.convertirVentas(ventaRepository.findAll());
	}

	public boolean crearOActualizar(Venta venta) {
		try {
			ventaRepository.save(venta);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean borrar(int id) {
		try {
			Venta venta = ventaRepository.findById(id);
			ventaRepository.delete(venta);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}

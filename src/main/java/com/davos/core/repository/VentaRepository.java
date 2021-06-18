package com.davos.core.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davos.core.entity.*;

public interface VentaRepository extends JpaRepository<Venta, Serializable> {
	
	public abstract Venta findById(int id);

	public abstract List<Venta> findByFecha(LocalDate fecha);
	
	public abstract Venta findByFechaAndCliente(LocalDate fecha, Cliente cliente);
	
	public abstract List<Venta> findByCliente(Cliente cliente);
	
	public abstract List<Venta> findByVendedor(Vendedor vendedor);
	
	public abstract List<Venta> findByMercaderia(Mercaderia mercaderia);
}

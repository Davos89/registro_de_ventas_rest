package com.davos.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davos.core.entity.*;

public interface VendedorRepository extends JpaRepository<Vendedor, Serializable> {
	
	public abstract Vendedor findByNombre(String nombre);
	
	public abstract Vendedor findById(int id);

}

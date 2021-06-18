package com.davos.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davos.core.entity.*;

public interface MercaderiaRepository extends JpaRepository<Mercaderia, Serializable> {
	
	public abstract Mercaderia findByNombre(String nombre);
	
	public abstract Mercaderia findById(int id);

}

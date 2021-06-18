package com.davos.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davos.core.entity.*;

public interface ClienteRepository extends JpaRepository<Cliente, Serializable> {

	public abstract Cliente findByNombre(String nombre);
	
	public abstract Cliente findById(int id);
}

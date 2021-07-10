package com.davos.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davos.core.entity.*;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Serializable> {

	public abstract Customer findByName(String name);
	
	public abstract Customer findById(int id);
}

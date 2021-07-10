package com.davos.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davos.core.entity.*;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Serializable> {
	
	public abstract Grocery findByName(String name);
	
	public abstract Grocery findById(int id);

}

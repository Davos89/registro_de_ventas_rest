package com.davos.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davos.core.entity.*;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Serializable> {
	
	public abstract Seller findByName(String name);
	
	public abstract Seller findById(int id);

}

package com.davos.core.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davos.core.entity.*;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Serializable> {
	
	public abstract Sale findById(int id);

	public abstract List<Sale> findByDate(LocalDate date);
	
	public abstract Sale findByDateAndCustomer(LocalDate date, Customer customer);
	
	public abstract List<Sale> findByCustomer(Customer customer);
	
	public abstract List<Sale> findBySeller(Seller seller);
	
	public abstract List<Sale> findByGrocery(Grocery grocery);
	
	public abstract Page<Sale> findAll(Pageable pageable);
}

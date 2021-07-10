package com.davos.core.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.davos.core.dto.SaleDTO;
import com.davos.core.entity.Customer;
import com.davos.core.entity.Grocery;
import com.davos.core.entity.Seller;

@Service
public interface SaleService {
	
	public List<SaleDTO> getByCustomerAndYear(int idCustomer, int year);

	public List<SaleDTO> getByDate(LocalDate date);
	
	public float getByYearAndGrocery(int year, int idGrocery);

	public List<SaleDTO> getByGrocery(Grocery grocery);

	public List<SaleDTO> getBySeller(Seller seller);

	public List<SaleDTO> getByPagination(Pageable pageable);
	
	public List<SaleDTO> getAll();

	public SaleDTO getById(int id);

	public SaleDTO getByDateAndCustomer(LocalDate date, Customer customer);

	public boolean createOrUpdate(SaleDTO saleDTO);

	public boolean delete(int id);

}

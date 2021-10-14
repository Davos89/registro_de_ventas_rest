package com.davos.core.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.davos.core.dto.SaleByDateDTO;
import com.davos.core.dto.SaleByMonthDTO;
import com.davos.core.dto.SaleDTO;
import com.davos.core.entity.Customer;
import com.davos.core.entity.Grocery;
import com.davos.core.entity.Seller;

@Service
public interface SaleService {
	
	/**
	 * 
	 * @param idCustomer an {@code int} that represents a {@code Customer} identifier
	 * @param year the year of the sales
	 * @return a list of all {@code SaleDTO} filtered by the parameters
	 */
	public List<SaleDTO> getSales(int idCustomer, int year);

	/**
	 * 
	 * @param date the date of the sales
	 * @return a list of all {@code SaleDTO} filtered by date
	 */
	public List<SaleDTO> getSales(LocalDate date);
	
	/**
	 * 
	 * @param date the date of the sales
	 * @return all units sold in this date
	 */
	public float getUnits(LocalDate date);
	
	/**
	 * 
	 * @param idGocery an {@code int} that represents a {@code Grocery} identifier
	 * @param dateInit the date for the first sales required
	 * @param dateEnd the date for the last sales required 
	 * @return a list of all {@code SaleDTO} by a {@code Customer} between both dates 
	 */
	public List<SaleDTO> getSales(int idGocery, LocalDate dateInit, LocalDate dateEnd);
	
	/**
	 * 
	 * @param idGrocery an {@code int} that represents a {@code Grocery} identifier
	 * @param year the year of the dates required
	 * @return an ordered {@code Set} of dates filtered by {@code Grocery} an year
	 */
	public Set<LocalDate> getDates(int idGrocery, int year);
	
	/**
	 * 
	 * @param year the year of the sales
	 * @param idGrocery an {@code int} that represents a {@code Grocery} identifier
	 * @return units of {@code Grocery} sold that year 
	 */
	public float getUnits(int year, int idGrocery);

	/**
	 * 
	 * @param year the year of the sales
	 * @param idGrocery an {@code int} that represents a {@code Grocery} identifier
	 * @return amount of {@code Grocery} sold that year 
	 */
	public int getAmount(int year, int idGrocery);
	/**
	 * 
	 * @param grocery the {@code Grocery} sold
	 * @return a list of all {@code SaleDTO} for that {@code Grocery}
	 */
	public List<SaleDTO> getSales(Grocery grocery);

	/**
	 * 
	 * @param seller the {@code Seller} who made the sales 
	 * @return a list of all {@code SaleDTO} for that {@code Seller}
	 */
	public List<SaleDTO> getSales(Seller seller);

	/**
	 * 
	 * @param pageable
	 * @return a list of all {@code SaleDTO} paged
	 */
	public List<SaleDTO> getSales(Pageable pageable);
	
	/**
	 * 
	 * @param id the identifier of the {@code Sale} 
	 * @return the {@code SaleDTO} that matches with the identifier
	 * 
	 * @throws RecordNotFoundException when the record doesn´t exists
	 */
	public SaleDTO getSale(int id);

	/**
	 * 
	 * @param date the date of the {@code Sale}
	 * @param customer the {@code Customer} who made the purchase
	 * @return the {@code SaleDTO} that matches with that date and {@code Customer}
	 * 
	 * @throws RecordNotFoundException when the record doesn´t exists
 	 */
	public SaleDTO getSale(LocalDate date, Customer customer);

	/**
	 * 
	 * @param saleDTO a sale to create a record or update it in database
	 */
	public void createOrUpdate(SaleDTO saleDTO);

	/**
	 * 
	 * Try to delete a {@code Sale} in the database 
	 * 
	 * @param id the identifier of a {@code Sale}
	 * 
	 * @throws RecordNotFoundException when the record doesn´t exists
	 */
	public void delete(int id);

	/**
	 * 
	 * @param idSeller the identifier of the {@code Seller} who made the sales 
	 * @param year the year of the sales 
	 * @param idGrocery the identifier of the {@code Grocery} sold
	 * @return the units of {@code Sale} sold for a {@code Seller}, in a year  
	 */
	public float getUnits(int idSeller, int year, int idGrocery);
	
	/**
	 * 
	 * 
	 * 
	 * @param idGrocery the identifier of the {@code Grocery} sold
	 * @param dates an ordered {@code Set} of dates
	 * @return a list of {@code SaleByDateDTO}. Each contains the amount and the units sold
	 * of a {@code Grocery} for each date in  {@code Set}
	 */
	public List<SaleByDateDTO> getSalesByDates(int idGrocery, Set<LocalDate> dates);
	
	/**
	 * 
	 * @param year
	 * @param idGrocery
	 * @return
	 */
	public List<SaleByMonthDTO> getSalesByMonth(int year,int idGrocery);
	
	

}

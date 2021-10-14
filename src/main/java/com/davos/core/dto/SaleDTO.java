package com.davos.core.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.davos.core.entity.*;
import com.davos.core.repository.CustomerRepository;
import com.davos.core.repository.GroceryRepository;
import com.davos.core.repository.SellerRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private GroceryRepository groceryRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Getter
	@Setter
	private int id;

	@Getter
	@Setter
	private LocalDate date;

	@Getter
	@Setter
	private float units;

	@Getter
	@Setter
	private int unitPrice;

	@Getter
	@Setter
	private int idCustomer;

	@Getter
	@Setter
	private int idGrocery;

	@Getter
	@Setter
	private int idSeller;
	
	public SaleDTO(Sale sale) {
		this.id = sale.getId();
		this.date = sale.getDate();
		this.units = sale.getUnits();
		this.unitPrice = sale.getUnitPrice();
		this.idCustomer = sale.getCustomer().getId();
		this.idGrocery = sale.getGrocery().getId();
		this.idSeller = sale.getSeller().getId();
	}
	
	public Sale toSale() {
		return new Sale(this.id,this.date,this.units,this.unitPrice,
				customerRepository.findById(this.idCustomer),
				groceryRepository.findById(this.idGrocery),
				sellerRepository.findById(this.idSeller));
	}

	

	
}

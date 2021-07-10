package com.davos.core.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.davos.core.entity.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaleDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;

	private LocalDate date;

	private float units;

	private int unitPrice;

	
	private int idCustomer;

	
	private int idGrocery;

	
	private int idSeller;

	

	

}

package com.davos.core.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class SaleByDateDTO {
	
	private LocalDate date;
	private float unitsSold = 0;
	private long amountSold  = 0;
	
	public SaleByDateDTO(LocalDate date, List<SaleDTO> sales) {
		this.date = date;
		
		for (SaleDTO sale : sales) {
			this.unitsSold += sale.getUnits();
			this.amountSold += sale.getUnits() * sale.getUnitPrice();
		}
		
	}

}

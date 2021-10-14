package com.davos.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaleByMonthDTO {
	
	
	private String month;
	private int units, amount;
	
	

}

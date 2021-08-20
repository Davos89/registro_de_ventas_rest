package com.davos.core.dto;

import java.io.Serializable;

import com.davos.core.entity.Seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SellerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	public SellerDTO(Seller seller) {
		this.id = seller.getId();
		this.name = seller.getName();
	}

	public Seller toSeller() {
		// TODO Auto-generated method stub
		return new Seller(this.id, this.name);
	}

}

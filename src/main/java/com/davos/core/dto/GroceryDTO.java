package com.davos.core.dto;

import java.io.Serializable;

import com.davos.core.entity.Grocery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GroceryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	public GroceryDTO(Grocery grocery) {
		this.id = grocery.getId();
		this.name = grocery.getName();
	}

	public Grocery toGrocery() {
		
		return new Grocery(this.id,this.name);
	}

}

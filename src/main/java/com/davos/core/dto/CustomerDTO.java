package com.davos.core.dto;

import java.io.Serializable;

import com.davos.core.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	public CustomerDTO(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
	}

	public Customer toCustomer() {
		return new Customer(id, name);
	}

}

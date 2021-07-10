package com.davos.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "grocery")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Grocery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grocery", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	private List<Sale> sales;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	/**
	 * IMPORTANTE!!!
	 * @param sale
	 */
	public void addSales(Sale sale) {
		if (sales == null)
			sales = new ArrayList<>();

		sales.add(sale);
		sale.setGrocery(this);

	}
}

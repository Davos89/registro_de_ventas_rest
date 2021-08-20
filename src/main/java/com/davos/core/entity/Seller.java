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

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "seller")
@Data
@NoArgsConstructor
@ToString
public class Seller  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seller", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	private List<Sale> sales;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	public Seller(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * IMPORTANT!!!
	 * @param sale
	 */
	public void addSale(Sale sale) {
		if (sales == null)
			sales = new ArrayList<>();

		sales.add(sale);
		sale.setSeller(this);
		
	}



	

	
}

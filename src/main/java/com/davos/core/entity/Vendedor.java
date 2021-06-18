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

@Entity
@Table(name = "vendedor")
public class Vendedor  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Vendedor() {
		// TODO Auto-generated constructor stub
	}

	public Vendedor(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public List<Venta> getVentas() {
		return ventas;
	}


	/**
	 * IMPORTANTE!!!
	 * @param venta
	 */
	public void agregarVenta(Venta venta) {
		if (ventas == null)
			ventas = new ArrayList<>();

		ventas.add(venta);
		venta.setVendedor(this);
		
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nombre=" + nombre + "]";
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendedor", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	private List<Venta> ventas;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombre;
}

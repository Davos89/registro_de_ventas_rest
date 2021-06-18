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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(int id, String nombre) {
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
		if (ventas==null) ventas= new ArrayList<>();
			
		
		ventas.add(venta);
		venta.setCliente(this);
		
		
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + "]";
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Venta> ventas;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	@NotNull
	@Size(min = 2,message = "Debe introducir un nombre de al menos dos letras")
	private String nombre;
}

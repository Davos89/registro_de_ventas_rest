package com.davos.core.model;


import com.davos.core.entity.Vendedor;

public class MVendedor {

	public MVendedor(Vendedor vendedor) {
		this.id = vendedor.getId();
		this.nombre = vendedor.getNombre();
		

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

	

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nombre=" + nombre + "]";
	}

	

	private int id;

	private String nombre;
}

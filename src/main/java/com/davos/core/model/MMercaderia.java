package com.davos.core.model;


import com.davos.core.entity.Mercaderia;

public class MMercaderia {

	public MMercaderia(Mercaderia mercaderia) {
		this.id = mercaderia.getId();
		this.nombre = mercaderia.getNombre();

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
		return "Mercaderia [id=" + id + ", nombre=" + nombre + "]";
	}

	

	private int id;

	private String nombre;
}

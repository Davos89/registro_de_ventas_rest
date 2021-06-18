package com.davos.core.model;

import java.time.LocalDate;

import com.davos.core.entity.*;

public class MVenta {

	public MVenta(Venta venta) {
		this.id = venta.getId();
		this.fecha = venta.getFecha();
		this.unidades = venta.getUnidades();
		this.precioUnitario = venta.getPrecioUnitario();
		this.cliente = venta.getCliente().getId();
		this.mercaderia = venta.getMercaderia().getId();
		this.vendedor = venta.getVendedor().getId();
	}
	
	public MVenta(int id, LocalDate fecha, float unidades, int precioUnitario, int cliente, int mercaderia,
			int vendedor) {
		
		this.id = id;
		this.fecha = fecha;
		this.unidades = unidades;
		this.precioUnitario = precioUnitario;
		this.cliente = cliente;
		this.mercaderia = mercaderia;
		this.vendedor = vendedor;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {

		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public float getUnidades() {
		return unidades;
	}

	public void setUnidades(float unidades) {
		this.unidades = unidades;
	}

	public int getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public int getMercaderia() {
		return mercaderia;
	}

	public void setMercaderia(int mercaderia) {
		this.mercaderia = mercaderia;
	}

	public int getVendedor() {
		return vendedor;
	}

	public void setVendedor(int vendedor) {
		this.vendedor = vendedor;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", fecha=" + fecha + ", unidades=" + unidades + ", precioUnitario=" + precioUnitario
				+ ", cliente=" + cliente + ", mercaderia=" + mercaderia + ", vendedor=" + vendedor + "]";
	}

	private int id;

	private LocalDate fecha;

	private float unidades;

	private int precioUnitario;

	private int cliente;

	private int mercaderia;

	private int vendedor;
}

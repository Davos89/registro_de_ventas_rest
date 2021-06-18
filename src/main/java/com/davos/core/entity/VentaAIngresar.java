package com.davos.core.entity;

import java.util.GregorianCalendar;

public class VentaAIngresar {

	public VentaAIngresar() {
		// TODO Auto-generated constructor stub
	}

	public VentaAIngresar(String fecha, float unidades, int precioUnitario, int idCliente, int idMercaderia,
			int idVendedor) {
		this.fecha = fecha;
		this.unidades = unidades;
		this.precioUnitario = precioUnitario;
		this.idCliente = idCliente;
		this.idMercaderia = idMercaderia;
		this.idVendedor = idVendedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
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

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdMercaderia() {
		return idMercaderia;
	}

	public void setIdMercaderia(int idMercaderia) {
		this.idMercaderia = idMercaderia;
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}
	
	

	@Override
	public String toString() {
		return "VentaAIngresar [id=" + id + ", fecha=" + fecha + ", unidades=" + unidades + ", precioUnitario="
				+ precioUnitario + ", idCliente=" + idCliente + ", idMercaderia=" + idMercaderia + ", idVendedor="
				+ idVendedor + "]";
	}



	private int id;

	private String fecha;

	private float unidades;

	private int precioUnitario;

	private int idCliente;

	private int idMercaderia;

	private int idVendedor;

}

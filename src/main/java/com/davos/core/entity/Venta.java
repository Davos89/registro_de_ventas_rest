package com.davos.core.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "venta")
public class Venta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Venta() {
		// TODO Auto-generated constructor stub
	}

	public Venta(LocalDate fecha, float unidades, int precioUnitario, Cliente cliente, Mercaderia mercaderia,
			Vendedor vendedor) {
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Mercaderia getMercaderia() {
		return mercaderia;
	}

	public void setMercaderia(Mercaderia mercaderia) {
		this.mercaderia = mercaderia;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", fecha=" + fecha + ", unidades=" + unidades + ", precioUnitario=" + precioUnitario
				+ ", cliente=" + cliente + ", mercaderia=" + mercaderia + ", vendedor=" + vendedor + "]";
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fecha")
	@DateTimeFormat(pattern = "dd.MM.yyyy", iso = ISO.DATE)
	private LocalDate fecha;

	@Column(name = "unidades")
	private float unidades;

	@Column(name = "precioUnitario")
	private int precioUnitario;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "idMercaderia")
	private Mercaderia mercaderia;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "idVendedor")
	private Vendedor vendedor;
}

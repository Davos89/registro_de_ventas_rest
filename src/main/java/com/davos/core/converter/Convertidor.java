package com.davos.core.converter;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.davos.core.entity.*;
import com.davos.core.model.*;

@Component("convertidor")
public class Convertidor {

	
	
	public List<MCliente> convertirClientes(List<Cliente> clientes) {
		List<MCliente> mClientes = new ArrayList<>();
		
		for (Cliente cliente : clientes) {
			mClientes.add(new MCliente(cliente));
		}
		return mClientes;
	}
	
	public List<MMercaderia> convertirMercaderias(List<Mercaderia> mercaderias) {
		List<MMercaderia> mMercaderia = new ArrayList<>();
		
		for (Mercaderia mercaderia : mercaderias) {
			mMercaderia.add(new MMercaderia(mercaderia));
		}
		return mMercaderia;
	}
	
	public List<MVendedor> convertirVendedors(List<Vendedor> vendedores) {
		List<MVendedor> mVendedors = new ArrayList<>();

		for (Vendedor vendedor : vendedores) {
			mVendedors.add(new MVendedor(vendedor));
		}
		return mVendedors;
	}
	
	public List<MVenta> convertirVentas(List<Venta> ventas) {
		List<MVenta> mVentas = new ArrayList<>();
		
		for (Venta venta : ventas) {
			mVentas.add(new MVenta(venta));
		}
		return mVentas;
	}
}

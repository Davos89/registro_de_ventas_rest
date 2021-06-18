package com.davos.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davos.core.entity.*;
import com.davos.core.model.MVenta;
import com.davos.core.repository.ClienteRepository;
import com.davos.core.repository.MercaderiaRepository;
import com.davos.core.repository.VendedorRepository;
import com.davos.core.service.VentaService;

@RestController
@RequestMapping("/v1")
public class VentaController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private MercaderiaRepository mercaderiaRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private VentaService ventaService;

	@GetMapping("/ventasXCliente/{idCliente}")
	public List<MVenta> ventasXCliente(@PathVariable("idCliente") int idCliente){
		Cliente cliente = clienteRepository.findById(idCliente);
		
		return ventaService.obtenerPorCliente(cliente);
		
	}
	
	@GetMapping("/ventasXID/{id}")
	public MVenta ventasXId(@PathVariable("id") int id){
		
		
		return ventaService.obtenerPorId(id);
		
	}
	
	@GetMapping("/ventas")
	public List<MVenta> ventas(){
		
		
		return ventaService.obtener();
		
	}
	
	@PostMapping("/registraVenta")
	public boolean registraVenta(@RequestBody @Valid MVenta mVenta) {
		
		Cliente cliente = clienteRepository.findById(mVenta.getCliente());
		Mercaderia mercaderia = mercaderiaRepository.findById(mVenta.getMercaderia());
		Vendedor  vendedor = vendedorRepository.findById(mVenta.getVendedor());
		
		return ventaService.crearOActualizar(new Venta(mVenta.getFecha(), mVenta.getUnidades(), mVenta.getPrecioUnitario(), cliente, mercaderia, vendedor));
	}
	
	@PutMapping("/actualizaVenta")
	public boolean actualizaVenta(@RequestBody @Valid MVenta mVenta) {
		
		
		Cliente cliente = clienteRepository.findById(mVenta.getCliente());
		Mercaderia mercaderia = mercaderiaRepository.findById(mVenta.getMercaderia());
		Vendedor  vendedor = vendedorRepository.findById(mVenta.getVendedor());
		
		Venta venta = new Venta(mVenta.getFecha(), mVenta.getUnidades(), mVenta.getPrecioUnitario(), cliente, mercaderia, vendedor);
		venta.setId(mVenta.getId());
		
		return ventaService.crearOActualizar(venta);
	}
	
	@DeleteMapping("/ventaDel/{id}")
	public boolean borrarVenta(@PathVariable("id") int id) {
		return ventaService.borrar(id);
	}
	
	
}

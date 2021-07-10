package com.davos.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davos.core.dto.SaleDTO;
import com.davos.core.service.SaleService;

@RestController
@RequestMapping("/v1/sale")
public class SaleController {
	
	
	
	@Autowired
	private SaleService service;
	
	
	
	@GetMapping("/amountByYear/{year}/{idGrocery}")
	public int amountByYear(@PathVariable("year") int year, @PathVariable("idGrocery") int idGrocery) {
		
		
		List<SaleDTO> sales = service.getAll();
		
		int salesTotalesPorAnio = 0;
		
		for (SaleDTO sale : sales) {
			if (sale.getDate().getYear() == year && sale.getIdGrocery() == idGrocery) {
				salesTotalesPorAnio += sale.getUnits()*sale.getUnitPrice();
			}
		}
		
		return salesTotalesPorAnio;
	}
	
	@GetMapping("/unitsByYear/{year}/{idGrocery}")
	public float unitsByYear(@PathVariable("year") int year, @PathVariable("idGrocery") int idGrocery) {
		
		return service.getByYearAndGrocery(year, idGrocery);
	}
	
	

	@GetMapping("/salesByCustomer/{year}/{idCustomer}")
	public List<SaleDTO> salesByCustomer(@PathVariable("year") int year, 
			@PathVariable("idCustomer") int idCustomer){
		
		return service.getByCustomerAndYear(idCustomer,year);
		
	}
	
	@GetMapping("/{id}")
	public SaleDTO salesById(@PathVariable("id") int id){
		
		
		return service.getById(id);
		
	}
	
	@GetMapping()
	public List<SaleDTO> getAll(Pageable pageable){
		
		
		return service.getByPagination(pageable);
		
	}
	
	@PostMapping()
	public boolean recordSale(@RequestBody @Valid SaleDTO saleDTO) {
		
		return service.createOrUpdate(saleDTO);
	}
	
	@PutMapping()
	public boolean updateSale(@RequestBody @Valid SaleDTO saleDTO) {
		
		return service.createOrUpdate(saleDTO);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable("id") int id) {
		return service.delete(id);
	}
	
	
}

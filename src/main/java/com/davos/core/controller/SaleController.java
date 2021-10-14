package com.davos.core.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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

import com.davos.core.dto.SaleByDateDTO;
import com.davos.core.dto.SaleByMonthDTO;
import com.davos.core.dto.SaleDTO;
import com.davos.core.http_errors.InvalidEntityException;
import com.davos.core.service.SaleService;

@RestController
@RequestMapping("/v1/sale")
public class SaleController {

	@Autowired
	private SaleService service;

	@GetMapping("/amountByYear/{year}/{idGrocery}")
	public int amountByYear(@PathVariable("year") int year, 
			@PathVariable("idGrocery") int idGrocery) {

		return service.getAmount(year, idGrocery);
	}

	@GetMapping("/unitsByYear/{year}/{idGrocery}")
	public float unitsByYear(@PathVariable("year") int year, 
			@PathVariable("idGrocery") int idGrocery) {

		return service.getUnits(year, idGrocery);
	}

	@GetMapping("/unitsBySellerAndYear/{idSeller}/{year}/{idGrocery}")
	public float unitsBySellerAndYear(@PathVariable("idSeller") int idSeller, 
			@PathVariable("year") int year,
			@PathVariable("idGrocery") int idGrocery) {

		return service.getUnits(idSeller, year, idGrocery);
	}

	@GetMapping("/salesByCustomer/{year}/{idCustomer}")
	public List<SaleDTO> salesByCustomer(@PathVariable("year") int year, 
			@PathVariable("idCustomer") int idCustomer) {

		return service.getSales(idCustomer, year);

	}

	@GetMapping("/salesBetweenDates/{dateInit}/{dateEnd}/{idGrocery}")
	public List<SaleDTO> salesBetweenDates(@PathVariable("dateInit") String dateInit,
			@PathVariable("dateEnd") String dateEnd, @PathVariable("idGrocery") int idGrocery) {

		return service.getSales(idGrocery, LocalDate.parse(dateInit), LocalDate.parse(dateEnd));

	}

	@GetMapping("/unitsAndAmountByDates/{year}/{idGrocery}")
	public List<SaleByDateDTO> unitsAndAmountByDates(@PathVariable("year") int year,
			@PathVariable("idGrocery") int idGrocery) {

		Set<LocalDate> dates = service.getDates(idGrocery, year);

		return service.getSalesByDates(idGrocery, dates);

	}
	@GetMapping("/unitsAndAmountByMonth/{year}/{idGrocery}")
	public List<SaleByMonthDTO> unitsAndAmountByMonth(@PathVariable("year") int year,
			@PathVariable("idGrocery") int idGrocery) {

		
		return service.getSalesByMonth(year, idGrocery);

	}

	@GetMapping("/{id}")
	public SaleDTO salesById(@PathVariable("id") int id) {

		return service.getSale(id);

	}

	@GetMapping()
	public List<SaleDTO> getAll(Pageable pageable) {

		return service.getSales(pageable);

	}

	@PostMapping()
	public void recordSale(@RequestBody @Valid SaleDTO saleDTO) {

		if (saleDTO.getIdCustomer() <= 0 || saleDTO.getIdGrocery() <= 0 || saleDTO.getIdSeller() <= 0
				|| saleDTO.getDate().isBefore(LocalDate.of(2000, 1, 1)) || saleDTO.getUnitPrice() <= 0
				|| saleDTO.getUnits() <= 0) {
			throw new InvalidEntityException(
					"The entity of type SaleDTO.class you are trying to " + "save contains one or more invalid fields");
		}

		service.createOrUpdate(saleDTO);
	}

	@PutMapping()
	public void updateSale(@RequestBody @Valid SaleDTO saleDTO) {

		service.createOrUpdate(saleDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") int id) {
		service.delete(id);
	}

}
